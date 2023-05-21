package com.wsl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsl.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName BookMapper.java
 * @Description TODO
 * @createTime 2021年11月14日 13:38:00
 */
@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
