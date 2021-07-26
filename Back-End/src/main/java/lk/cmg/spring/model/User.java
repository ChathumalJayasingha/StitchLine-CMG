package lk.cmg.spring.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="user")
public class User {
    @Id
    private String email;
    private String name;
    private String mobile;
    private String userName;
    private String password;
    private String address;
    private String type;
    private String nic;
    private String employeeNumber;
}
