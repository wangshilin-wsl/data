package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int empid;
    private String realname;
    private String username;
    private String password;
    private String tel;
    private String email;
}
