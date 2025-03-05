package CTTNHH_BaooLam_Group.Practice_English_App_BE.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.UserDTO.UserSignRequest;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.DataTranferOject.UserDTO.UserSignResponse;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.Entity.User;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.Exeption.ResourceAlreadyExistsException;
import CTTNHH_BaooLam_Group.Practice_English_App_BE.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserSignResponse createUser(UserSignRequest userSignRequest) {

        String existedUser = userRepository.findByUsername(userSignRequest.getUsername());
        if(existedUser != null){
            throw new ResourceAlreadyExistsException("Username already exists!");
        }

        String username = userSignRequest.getUsername();
        String password = userSignRequest.getPassword();
        
        User newUser = convertToUser(userSignRequest);
   

        User savedUser = userRepository.save(newUser);

        return convertToUserResponse(savedUser);

    }

    private UserSignResponse convertToUserResponse(User user){
        UserSignResponse userSignResponse = new UserSignResponse();
        userSignResponse.setUsername(user.getUsername());
        userSignResponse.setPassword(user.getPassword());
        return userSignResponse;
    }

    private User convertToUser(UserSignRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }
    
}
