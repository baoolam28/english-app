package CTTNHH_BaooLam_Group.Practice_English_App_BE.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.Entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    String findByUsername(String username);

    
} 