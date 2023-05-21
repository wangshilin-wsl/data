package com.wsl.service;

import com.github.pagehelper.PageInfo;
import com.wsl.pojo.Category;

public interface CategoryService {
    int addCategory(Category category);
    PageInfo<Category> search(Category category, int pageindex, int pagesize);
    Category getCategoryById(Integer id);
    int editCategory(Category category);
    int delCategoryById(Integer id);
}
