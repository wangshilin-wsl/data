package com.wsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName UserMapper.java,在对应的mapper集成一个BaseMapper
 * @Description TODO
 * @createTime 2021年10月31日 16:32:00
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUser(Integer id);
}
