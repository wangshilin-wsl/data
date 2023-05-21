package com.rms.dao;

import com.rms.entity.Rm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Mapper
public interface RmDao {
    List<Rm> findAll();

    void save(Rm emp);
    void delete(String id);
    Rm findOne(String id);

    void update(Rm emp);
}
