import com.wsl.pojo.Books;
import com.wsl.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bean = (BookService)context.getBean("BookServiceImpl");
        for(Books b:bean.queryAllBook()){
            System.out.println(b);
        }
    }
}
