package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int custid;
    private String custname;
    private String contacts;
    private String tel;
    private String email;
    private int empid;

    public Customer(String custname, String contacts, String tel, String email, int empid) {
        this.custname = custname;
        this.contacts = contacts;
        this.tel = tel;
        this.email = email;
        this.empid = empid;
    }
}
