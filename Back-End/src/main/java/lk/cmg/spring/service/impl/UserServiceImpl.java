package lk.cmg.spring.service.impl;

import lk.cmg.spring.exception.ValidateException;
import lk.cmg.spring.model.User;
import lk.cmg.spring.repo.UserRepo;
import lk.cmg.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUser(User dto) {

        if (!userRepo.existsByUserName(dto.getUserName())){
            if (!userRepo.existsById(dto.getEmail())) {
                userRepo.save(dto);
            } else {
                throw new ValidateException("'"+dto.getEmail()+"'"+" <- This Email already Exist in this Database");
            }
        }else{
            throw new ValidateException("'"+dto.getUserName()+"'"+" <- This user name is already Exist in this Database");
        }


    }

    @Override
    public void updateUser(User dto) {
        if (userRepo.existsById(dto.getEmail())){
            userRepo.save(dto);
        } else {
            throw new ValidateException(dto.getEmail()+" <- This user Not Found for update in this database");
        }
    }

    @Override
    public void deleteUser(String id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This user cant delete in this database");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User searchUser(String email) {
        Optional<User> user = userRepo.findById(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ValidateException(email+" <- This user Not Found in this database");
        }
    }

    @Override
    public User findByUserName(String userName) {
        User byUserName = userRepo.findByUserName(userName);
        if (byUserName == null) {
            throw new ValidateException(userName+" <- This userName Not Found in this database");
        }else{
            return byUserName;
        }
    }


}
