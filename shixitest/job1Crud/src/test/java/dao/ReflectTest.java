package dao;

import org.junit.Test;
import pojo.Customer;
import pojo.Employee;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import utils.ServiceProxyHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;

public class ReflectTest {
    //反射
    @Test
    public void test1(){
        String name1="pojo.Customer";
        try {
            Class aClass = Class.forName(name1);
            //获取类的修饰符
            String modify = Modifier.toString(aClass.getModifiers());
            //获取类的名字
            String name=aClass.getName();
            System.out.println(modify+" "+name+"{");
            //获取所有属性
            Field[] fields=aClass.getDeclaredFields();
            for (Field f:fields) {
                //获取属性的修饰符
               modify=Modifier.toString(f.getModifiers());
                //获取属性的类型
                String type = f.getType().getName();
                //获取属性的名字
               name=f.getName();
               System.out.println(modify+" "+type+" "+name+";");
            }
            //获取所有的构造方法
            Constructor[] constructors=aClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //获取构造方法的修饰符
                modify=Modifier.toString(constructor.getModifiers());
                //获取构造方法的名字
                name=constructor.getName();
                //获取参数的类型
                Class[] parameterTypes = constructor.getParameterTypes();
                System.out.print(modify+" "+name+"(");
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType.getName()+",");
                }
                System.out.println("){}");
            }
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                //获取普通方法的修饰符
                modify=Modifier.toString(method.getModifiers());
                //获取参数的类型
                String type=method.getReturnType().getName();
                //获取普通方法的名字
                name=method.getName();
                Class[] parameterTypes = method.getParameterTypes();
                System.out.print(modify+" "+type+" "+name+"(");
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType.getName()+",");
                }
                System.out.println("){}");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("}");
    }
    @Test
    public void test2(){
        String name1="pojo.Customer";
        String fieldName="custname";
        String fileValue="张三";
        String methodName="setTel";
        String argValues="3218309";
        String argsTypes="java.lang.String";
        try {
            Class cls = Class.forName(name1);
            //创建一个该类的对象
           // Object obj = cls.newInstance();
            //通过构造方法创建一个该类的对象
            Constructor constructor = cls.getConstructor();
            Object obj = constructor.newInstance();


            Field field = cls.getDeclaredField(fieldName);
            //使私有的属性也可以强制赋值
            field.setAccessible(true);
            field.set(obj,fileValue);
            Class type = Class.forName(argsTypes);
            //得到指定的方法
            Method method = cls.getDeclaredMethod(methodName, type);
            //执行该方法
            method.invoke(obj,argValues);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //动态代理
    @Test
    public void test3Proxy() throws SQLException {
        //在CustmoerServiceImpl中增加一个日志功能
        CustomerService service = new ServiceProxyHandler<CustomerService>().createProxyService(new CustomerServiceImpl());
        Customer customer = service.searchById(3);
    }
    @Test
    public void test4Proxy() throws SQLException {
        //在CustmoerServiceImpl中增加一个日志功能
        EmployeeService service = new ServiceProxyHandler<EmployeeService>().createProxyService(new EmployeeServiceImpl());
        Employee employee = service.login("wangwu", "111");
        System.out.println(employee);
    }
}
