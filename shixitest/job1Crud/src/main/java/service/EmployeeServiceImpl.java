package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojo.Employee;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao dao=new EmployeeDaoImpl();
    @Override
    public Employee login(String username,String password) throws SQLException {
        Employee realemp=null;
        realemp = dao.selectByUsername(username );
        if(realemp!=null)
            if(realemp.getPassword().equals(password)){
                return realemp;
            }
        return null;
    }
}
