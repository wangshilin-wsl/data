package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import pojo.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao customerDao=new CustomerDaoImpl();

    @Override
    public Customer searchById(int custid) throws SQLException {
        Customer customer = customerDao.selectById(custid);
        return customer;
    }

    @Override
    public int addCustomer(Customer customer) throws SQLException {
        int result;
            Customer real = customerDao.selectByName(customer.getCustname());
            if(real==null){
                result=customerDao.insertCust(customer);
            }else{
                result=-1;
            }
        return result;
    }

    @Override
    public List<Customer> search(Customer customer,int pageindex,int pagesize) throws SQLException {
        List<Customer> list;
        list = customerDao.selectByCust(customer,pageindex,pagesize);
        return list;
    }

    @Override
    public int deleteCustomer(int custid) throws SQLException {
        int i = customerDao.deleteCust(custid);
        return i;
    }

    @Override
    public int updateCustomer(Customer customer) throws SQLException {
        int i=0;
        Customer realcust = customerDao.selectByName(customer.getCustname());
        if(realcust==null) {
           i = customerDao.updateCust(customer);
        }else{
            i=-1;
        }
        return i;
    }

    @Override
    public int getPageCountByCust(Customer customer, int pagesize) throws SQLException {
        int i = customerDao.selectCountByCust(customer);
        int num;
        if(i%2==0){
            num=i/pagesize;
        }else{
            num=i/pagesize+1;
        }
        return num;
    }

    @Override
    public int manyDel(String[] ids) throws SQLException {
       Integer[] ints=new Integer[ids.length];
       for(int i=0;i<ids.length;i++){
           ints[i]=Integer.parseInt(ids[i]);
       }
        int i =0;
        i=customerDao.delMany(ints);
        return i;
    }
}
