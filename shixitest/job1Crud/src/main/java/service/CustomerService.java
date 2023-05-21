package service;

import pojo.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    Customer searchById(int custid) throws SQLException;
    int addCustomer(Customer customer) throws SQLException;
    List<Customer> search(Customer customer ,int pageindex,int pagesize) throws SQLException;
    int deleteCustomer(int custid) throws SQLException;
    int updateCustomer(Customer customer) throws SQLException;
    int getPageCountByCust(Customer customer,int pagesize) throws SQLException;
    int manyDel(String[] ids) throws SQLException;
}
