import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wsl.config.MyConfig;
import wsl.pojo.User;

public class MyTest {
    @Test
    public void test(){
        //如果完全使用了配置类的方式去做，我们就只能通过annotationconfig上下文来获取容器，通过配置类的class对象来加载
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = (User)context.getBean("getUser");
        System.out.println(user.getName());
    }
}
