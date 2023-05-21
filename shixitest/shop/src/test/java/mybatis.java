import com.wsl.dao.AdminMapper;
import com.wsl.pojo.Admin;
import com.wsl.pojo.AdminExample;
import com.wsl.pojo.Userinfo;
import com.wsl.service.UserinfoServiceImpl;
import com.wsl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class mybatis {

    @Test
    public void test8(){
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("wangwu");
        userinfo.setPassword("111");
        Userinfo login = new UserinfoServiceImpl().login(userinfo);
        System.out.println(login);
    }
    @Test
    public void test9(){
        SqlSession sqlSession = MybatisUtils.getsqlSession();
        AdminMapper mapper =sqlSession .getMapper(AdminMapper.class);
        Admin admin=new Admin();
        admin.setUsername("wangshilint");
        admin.setAdminid(null);
        admin.setPassword("111");
        admin.setRealname("王世林1");
        int i = mapper.insert(admin);
        System.out.println(i);
        sqlSession.commit();
    }
    @Test
    public void test10(){
        SqlSession sqlSession = MybatisUtils.getsqlSession();
        AdminMapper mapper =sqlSession .getMapper(AdminMapper.class);
        Admin admin=new Admin();
        admin.setPassword("4343");
        AdminExample example=new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo("wangshilin");
        AdminExample.Criteria criteria1 = example.or();
        criteria1.andUsernameEqualTo("wangshilint");
        mapper.updateByExampleSelective(admin,example);
        sqlSession.commit();
    }
}
