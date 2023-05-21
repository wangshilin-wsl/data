package mapper;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    //我们的所有操作，都是用sqlsession来执行，现在使用sqlsessiontemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> query() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.query();
    }
}
