package utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceProxyHandler<T> implements InvocationHandler {
    //被代理的对象
    private T proxyObj;
    //返回代理的对象
    public T createProxyService(T proxyObj){
        this.proxyObj=proxyObj;
        T proxyAfter =(T)Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(),
                proxyObj.getClass().getInterfaces(), this);
        return proxyAfter;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws SQLException {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConn();
            conn.setAutoCommit(false);
            //实现简单的日志功能
            System.out.println("---启动事务---");
            method.setAccessible(true);
            Object result = method.invoke(proxyObj, args);
            conn.commit();
            System.out.println("---事务提交---");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }finally {
           // JdbcUtils.close(conn);
        }
        return null;
    }
}
