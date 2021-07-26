package lk.cmg.spring.controller;
import lk.cmg.spring.model.User;
import lk.cmg.spring.service.UserService;
import lk.cmg.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity(new StandardResponse("201", "Done", allUsers), HttpStatus.CREATED);
    }

    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity(new StandardResponse("201", "Done", user), HttpStatus.CREATED);
    }

    @GetMapping ("/findUser/{email}")
    public ResponseEntity searchUser(@PathVariable String email){
        User user = userService.searchUser(email);
        return new ResponseEntity(new StandardResponse("201", "Done", user), HttpStatus.CREATED);
    }

    @GetMapping ("/findUserByUserName/{userName}")
    public ResponseEntity findUserByUserName(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        return new ResponseEntity(new StandardResponse("201", "Done", user), HttpStatus.CREATED);
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseEntity(new StandardResponse("201", "Done", user), HttpStatus.CREATED);
    }


    @DeleteMapping(params = {"email"})
    public ResponseEntity deleteUser(@RequestParam String email){
        userService.deleteUser(email);
        return new ResponseEntity(new StandardResponse("201", "Done", email), HttpStatus.CREATED);
    }




}



//           Software Engineering Internship Assignment
//          Mobilevision | Capital Maharaja Group
//        You are contracted to develop a Login for company e-business called “Stitch-Line”. The system
//        has 2 types of users: Admin and Customers.
//        Business rules:
//        1. Each user can register the system.
//        2. Each user can login to the system after registration. After Login will redirect you to the
//        customer page or admin page.
//        Implementation:
//        1. Every user must input their Name, Email, Mobile, Username and Password
//        2. Customer should input their Address
//        3. Admin should input their NIC and Employee Number
//        4. Every field is mandatory and must validate.
//        5. You should develop 1 API and 1 form for registering both types of users.
//        6. You should store both types of user data in 1 table in the database.
//        7. In the login, you should redirect either customer or admin page according to the type of
//        user.
//        Technologies:
//        1. API : Spring-boot
//        2. Frontend : any JS framework. (JQuery, Angular, React, etc)
//        3. Database : NoSQL (MongoDB or any other NoSQL DB)
//        Use Kotlin instead of Java to develop Spring-boot app will get huge advantage
//        References:
//        1. https://www.youtube.com/watch?v=k5PeywcbVYc
//        2. https://www.youtube.com/watch?v=Eor-iXU0xR0
