package com.rms.service;

import com.rms.entity.Rm;

import java.util.List;

public interface RmService {
    List<Rm> findAll();

    void save(Rm emp);
    void delete(String id);
    Rm findOne(String id);
     void update(Rm emp);
}
