package dao;

import pojo.Employee;
import utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public int insertEmp( Employee emp) throws SQLException {
        String sql="insert into employee values(?,?,?,?,?,?)";
        int i = super.exeUpdate( sql, emp.getEmpid(), emp.getRealname(),
                emp.getUsername(), emp.getPassword(), emp.getTel(), emp.getEmail());
        return i;
    }

    @Override
    public int updateEmp( Employee emp) throws SQLException {
        String sql="update employee set realname=?,username=?,password=?,tel=?,email=? where empid=?";
        int i = super.exeUpdate(sql, emp.getRealname(),
                emp.getUsername(), emp.getPassword(), emp.getTel(), emp.getEmail(), emp.getEmpid());
        return i;
    }

    @Override
    public int delEmpByID( int id) throws SQLException {
        String sql="delete from employee where empid=?";
        int i = super.exeUpdate(sql,id);
        return i;
    }

    @Override
    public Employee selectById( int id) throws SQLException {
        Employee employee=null;
        String sql="select * from employee where empid=?";
        employee = super.exeQuery(sql, new RowMapperImpl(), id);
        return employee;
    }

    @Override
    public Employee selectByUsername( String username) throws SQLException {
        Employee employee=null;
        String sql="select * from employee where username=?";
        employee = super.exeQuery(sql, new RowMapperImpl(), username);
        return employee;
    }

    @Override
    public List<Employee> selectAll() throws SQLException {
      List<Employee> employeeList=new ArrayList<>();
        String sql="select * from employee ";
        employeeList= super.exeQueryList(sql, new RowMapperImpl());
        return employeeList;
    }
    class RowMapperImpl implements RowMapper<Employee> {
        @Override
        public  Employee makeBean(ResultSet resultSet) throws SQLException {
            Employee employee=null;
            employee=new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)
                    ,resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            return employee;
        }
    }
}
