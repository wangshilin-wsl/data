package dao;

import pojo.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
     int insertCust(Customer customer) throws SQLException;
    int deleteCust(int custid) throws SQLException;
    int updateCust(Customer customer) throws SQLException;
    Customer selectById(int custid) throws SQLException;
    Customer selectByName(String custname) throws SQLException;
    List<Customer> selectByempid(int empid) throws SQLException;
    List<Customer> selectByCust(Customer cust,int pageindex,int pagesize) throws SQLException;
    List<Customer> selectAll(Connection conn) throws SQLException;
    int selectCountByCust(Customer cust) throws SQLException;
    int delMany(Integer[] ids) throws SQLException;
}
