package com.wsl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsl.dao.CategoryMapper;
import com.wsl.dao.GoodsMapper;
import com.wsl.pojo.Category;
import com.wsl.pojo.CategoryExample;
import com.wsl.pojo.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Transactional
    @Override
    public int addCategory(Category category) {
        int result=0;
        CategoryExample example=new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(category.getName());
        List<Category> list = categoryMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            result=-1;
        }else {
            category.setGoodsnum(0);
             result = categoryMapper.insert(category);
        }
        return result;
    }

    @Override
    public PageInfo<Category> search(Category category,int pageindex,int pagesize) {
        CategoryExample example=new CategoryExample();
        if(category!=null){
            CategoryExample.Criteria criteria = example.createCriteria();
            if(category.getName()!=null&&!"".equals(category.getName())){
                criteria.andNameLike("%"+category.getName()+"%");
            }
        }
        PageHelper.startPage(pageindex,pagesize);
        List<Category> list = categoryMapper.selectByExample(example);
        System.out.println("list=="+list);
        PageInfo<Category> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Category getCategoryById(Integer id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        return category;
    }

    @Transactional
    @Override
    public int editCategory(Category category) {
        int result=0;
        CategoryExample example=new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(category.getName());
        List<Category> list = categoryMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            //名字没改
           if(category.getId().equals(list.get(0).getId())){
               result = categoryMapper.updateByPrimaryKey(category);
           }else {
               result=-1;
           }
        }else {
            result = categoryMapper.updateByPrimaryKey(category);
        }
        return result;
    }
    @Transactional
    @Override
    public int delCategoryById(Integer id) {
        int i=0;
        GoodsExample example=new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(id);
        long count = goodsMapper.countByExample(example);
        if(count>0){
            i=-1;
        }else {
            i = categoryMapper.deleteByPrimaryKey(id);
        }

        return i;
    }
}
