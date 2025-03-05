package CTTNHH_BaooLam_Group.Practice_English_App_BE.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;

    private String username;
    private String password;

}
