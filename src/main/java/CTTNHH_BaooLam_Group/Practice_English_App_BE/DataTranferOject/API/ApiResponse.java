package CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.API;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;
    

    public ApiResponse(int status, String message) {
        this(LocalDateTime.now(),status, message,null);
    }


}
