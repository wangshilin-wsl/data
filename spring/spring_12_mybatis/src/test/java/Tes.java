import mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class Tes {
    @Test
    public void t(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper mapper = context.getBean("userMapper", UserMapper.class);
        for(User u:mapper.query()){
            System.out.println(u);
        }
    }
}
