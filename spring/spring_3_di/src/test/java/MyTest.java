import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import pojo.User;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=(Student)context.getBean("student");
        System.out.println(student);
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
        User user = context.getBean("user2", User.class);
        System.out.println(user);
    }
}
