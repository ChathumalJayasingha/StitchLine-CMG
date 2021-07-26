package lk.cmg.spring.repo;

import lk.cmg.spring.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    boolean existsByUserName(String userName);
    User findByUserName(String userName);
}
