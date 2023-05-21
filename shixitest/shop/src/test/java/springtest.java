import com.wsl.pojo.Category;
import com.wsl.pojo.GoodsComplex;
import com.wsl.service.UserinfoServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springtest {
    @Test
    public void test1(){
        //获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //我们的对象现在都在Spring中管理，要使用，直接取出来
        Category category = context.getBean(Category.class);
        System.out.println(category);
        GoodsComplex goods = (GoodsComplex)context.getBean("goodsComplex");
        System.out.println(goods);
        UserinfoServiceImpl service = context.getBean(UserinfoServiceImpl.class);
        System.out.println(service);
    }
}
