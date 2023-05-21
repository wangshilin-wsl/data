package service;

import pojo.Employee;

import java.sql.SQLException;

public interface EmployeeService {
    Employee login(String username,String password) throws SQLException;
}
