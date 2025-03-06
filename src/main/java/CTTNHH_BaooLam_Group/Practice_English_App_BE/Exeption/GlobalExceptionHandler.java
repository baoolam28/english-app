package CTTNHH_BaooLam_Group.Practice_English_App_BE.Exeption;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.API.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> handleAlreadyExistsException(ResourceAlreadyExistsException e) {
        ApiResponse exceptionRes = new ApiResponse<>(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            e.getMessage(),
            null
        );
        return new ResponseEntity<>(exceptionRes, HttpStatus.CONFLICT); //status code 409
    }

    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<ApiResponse> handleNotfoundException(ResourceNotfoundException e) {
        ApiResponse exceptionRes = new ApiResponse<>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                null);
        return new ResponseEntity<>(exceptionRes, HttpStatus.NOT_FOUND); // status code 404
    }
}
