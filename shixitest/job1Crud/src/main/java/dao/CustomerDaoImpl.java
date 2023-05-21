package dao;

import pojo.Customer;
import utils.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public int insertCust( Customer customer) throws SQLException {
        String sql="insert into customer values(?,?,?,?,?,?)";
        int i = super.exeUpdate(sql, null, customer.getCustname()
                , customer.getContacts(), customer.getTel(), customer.getEmail(), customer.getEmpid());
        return i;
    }

    @Override
    public int deleteCust(int custid) throws SQLException {
        String sql="delete from  customer where custid=?";
        int i = super.exeUpdate(sql,custid);
        return i;
    }

    @Override
    public int updateCust(Customer customer) throws SQLException {
        String sql="update  customer set custname=?,contacts=?,tel=?,email=? where custid=?";
        int i = super.exeUpdate(sql,  customer.getCustname()
                , customer.getContacts(), customer.getTel(), customer.getEmail(),customer.getCustid());
        return i;
    }

    @Override
    public Customer selectById(int custid) throws SQLException {
        Customer customer=null;
       String sql="select * from customer where custid=?";
        customer = super.exeQuery(sql, new RowMapperImpl(), custid);
        return customer;
    }

    @Override
    public Customer selectByName(String custname) throws SQLException {
        Customer customer=null;
        String sql="select * from customer where custname=?";
        customer = super.exeQuery(sql,new RowMapperImpl(), custname);
        return customer;
    }

    @Override
    public List<Customer> selectByempid( int empid) throws SQLException {
        List<Customer> list=new ArrayList<>();
        String sql="select * from customer where empid=? order by custid desc";
        list = super.exeQueryList(sql, new RowMapperImpl(), empid);
        return list;
    }

    @Override
    public List<Customer> selectByCust( Customer cust,int pageindex,int pagesize) throws SQLException {
        List<Customer> list=new ArrayList<>();
        String sql="select * from customer where 1=1 ";
        List<Object> values=new ArrayList<>();
        if(cust!=null){
            if(cust.getEmpid()!=0){
                sql+=" and empid=?";
                values.add(cust.getEmpid());
            }
            if(cust.getCustname()!=null&&!"".equals(cust.getCustname())){
                sql+=" and custname like ?";
                values.add("%"+cust.getCustname()+"%");
            }
        }
        values.add((pageindex-1)*pagesize);
        values.add(pagesize);
        sql+=" order by custid desc limit ?,?";
        list= super.exeQueryList(sql, new RowMapperImpl(), values.toArray());
        return list;
    }

    @Override
    public List<Customer> selectAll(Connection conn) throws SQLException {
       List<Customer> list=new ArrayList<>();
    String sql="select * from customer order by custid desc";
    list= super.exeQueryList(sql, new RowMapperImpl());
        return list;
}

    @Override
    public int selectCountByCust( Customer cust) throws SQLException {
        String sql="select count(custid) cust_count from customer where 1=1";
        List<Customer> list=new ArrayList<>();
        List<Object> values=new ArrayList<>();
        int count=0;
        if(cust!=null){
            if(cust.getEmpid()!=0){
                sql+=" and empid=?";
                values.add(cust.getEmpid());
            }
            if(cust.getCustname()!=null&&!"".equals(cust.getCustname())){
                sql+=" and custname like ?";
                values.add("%"+cust.getCustname()+"%");
            }
        }
        ResultSet resultSet = super.exeQuery(sql,values.toArray());
        if(resultSet.next()){
            count=resultSet.getInt("cust_count");
        }
        return count;
    }

    @Override
    public int delMany( Integer[] ids) throws SQLException {
        String sql="delete from  customer where custid in (";
        for(int i=0;i<ids.length;i++){
            if(i==0){
                sql+="?";
            }else {
                sql +=",?";
            }
        }
        sql+=")";
        int i = super.executeUpdate(sql,ids);
        System.out.println("----"+sql+"----");
        return i;
    }
    class RowMapperImpl implements RowMapper<Customer>{
        @Override
        public  Customer makeBean(ResultSet resultSet) throws SQLException {
            Customer customer=null;
                customer=new Customer(resultSet.getInt(1),resultSet.getString(2)
                        ,resultSet.getString(3)
                        ,resultSet.getString(4)
                        ,resultSet.getString(5)
                        ,resultSet.getInt(6));
            return customer;
        }
    }
}
