package CTTNHH_BaooLam_Group.Practice_English_App_BE.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.Entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    
} 