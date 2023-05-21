package com.rms.service;

import com.rms.dao.RmDao;
import com.rms.entity.Rm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RmServiceImpl implements RmService {
    @Autowired
    private RmDao empDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Rm> findAll() {
        return empDao.findAll();
    }

    @Override
    public void save(Rm emp) {
        empDao.save(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    public Rm findOne(String id) {
        return empDao.findOne(id);
    }

    public void update(Rm emp) {
        empDao.update(emp);
    }
}
