package dao;

import org.junit.Test;
import pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeTest {
    @Test
    public void test1() throws SQLException {
        EmployeeDaoImpl dao = new EmployeeDaoImpl();
        List<Employee> list = dao.selectAll();
        for(Employee e:list){
            System.out.println(e);
        }
    }
}
