package dao;

import pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    int insertEmp( Employee emp) throws SQLException;
    int updateEmp( Employee emp) throws SQLException;
    int delEmpByID(int id) throws SQLException;
    Employee selectById(int id) throws SQLException;
    Employee selectByUsername(String username) throws SQLException;
    List<Employee> selectAll() throws SQLException;
}
