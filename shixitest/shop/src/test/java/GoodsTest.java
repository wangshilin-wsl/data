import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsl.dao.GoodsMapper;
import com.wsl.pojo.Goods;
import com.wsl.pojo.GoodsComplex;
import com.wsl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GoodsTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getsqlSession();
        GoodsMapper mapper =sqlSession .getMapper(GoodsMapper.class);
        GoodsComplex goods = mapper.selectComplexByPrimaryKey(1);
        System.out.println(goods);
        sqlSession.commit();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getsqlSession();
        GoodsMapper mapper =sqlSession .getMapper(GoodsMapper.class);
        //向threadlocal中存储分页信息
        PageHelper.startPage(0,2);
        //执行查询之前会自动执行分页的拦截器：读取threadlocal里的分页信息，重新组装要执行的sql语句，就是加limit
        //然后开始执行sql
        List<Goods> goods = mapper.selectByExample(null);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        System.out.println(pageInfo);
        for (Goods good : goods) {
            System.out.println(good);
        }
        sqlSession.commit();
    }
}
