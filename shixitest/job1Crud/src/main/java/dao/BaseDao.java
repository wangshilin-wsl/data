package dao;

import utils.JdbcUtils;
import utils.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    //增删改操作
    public int exeUpdate(String sql,Object ... values) throws SQLException {
        Connection conn= JdbcUtils.getConn();
        int result=0;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if(values!=null){
            for(int i=0;i<values.length;i++){
                pstm.setObject(i+1,values[i]);
            }
        }
        result = pstm.executeUpdate();
        return result;
    }
    public ResultSet exeQuery(String sql,Object ... values) throws SQLException {
        Connection conn= JdbcUtils.getConn();
        ResultSet result=null;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if(values!=null){
            for(int i=0;i<values.length;i++){
                pstm.setObject(i+1,values[i]);
            }
        }
        result=pstm.executeQuery();
        return result;
    }

    public int executeUpdate(String sql,Object[] values) throws SQLException {
        Connection conn= JdbcUtils.getConn();
        int result=0;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if(values!=null){
            for(int i=0;i<values.length;i++){
                pstm.setObject(i+1,values[i]);
            }
        }
        result = pstm.executeUpdate();
        return result;
    }

    public <T> T exeQuery( String sql, RowMapper<T> mapper, Object ... values) throws SQLException {
        Connection conn= JdbcUtils.getConn();
       T t=null;
        ResultSet result=null;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if(values!=null){
            for(int i=0;i<values.length;i++){
                pstm.setObject(i+1,values[i]);
            }
        }
        result=pstm.executeQuery();
        if(result.next()){
            t=mapper.makeBean(result);
        }
        return t;
    }
    public <T> List<T> exeQueryList( String sql, RowMapper<T> mapper, Object ... values) throws SQLException {
        Connection conn= JdbcUtils.getConn();
        System.out.println(sql);
        List<T> t=new ArrayList<>();
        ResultSet result=null;
        PreparedStatement pstm = conn.prepareStatement(sql);
        if(values!=null){
            for(int i=0;i<values.length;i++){
                pstm.setObject(i+1,values[i]);
            }
        }
        result=pstm.executeQuery();
        while (result.next()){
            T t1=mapper.makeBean(result);
            t.add(t1);
        }
        return t;
    }
}
