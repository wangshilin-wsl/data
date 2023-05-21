package com.wsl.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wsl.pojo.Category;
import com.wsl.service.CategoryServiceImpl;
import com.wsl.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl service;
    @RequestMapping("view/{viewname}")
    public String index(@PathVariable(name = "viewname")String viewname){
        return "admin/category_"+viewname;
    }
    @RequestMapping("doadd")
    @ResponseBody
    public JsonResult doAdd(Category category) throws IOException {
        int i = service.addCategory(category);
        JsonResult jsonResult=new JsonResult();
        jsonResult.setData(i);
        if(i==1){
            jsonResult.setStatusCode(0);//成功
            jsonResult.setMsg("添加成功");
        }else if (i==0){
            jsonResult.setStatusCode(500);//成功
            jsonResult.setMsg("添加失败");
        }else {
            jsonResult.setStatusCode(500);//成功
            jsonResult.setMsg("添加失败，类别名重复");
        }
        return jsonResult;
    }
    @RequestMapping("search")
    @ResponseBody
    public JsonResult search(Category category, @RequestParam(name = "pageindex",defaultValue = "1") Integer pageindex, @RequestParam(name = "pagesize",defaultValue = "3")Integer pagesize) throws IOException {
        System.out.println(category);
        PageInfo<Category> list = service.search(category,pageindex,pagesize);
        JsonResult jsonResult=new JsonResult();
        jsonResult.setData(list);
        return jsonResult;
    }

    @RequestMapping("toedit/{id}")
    public String toedit(@PathVariable(name = "id") Integer id, HttpServletRequest request){
        Category category = service.getCategoryById(id);
        request.setAttribute("category",category);
        return "admin/category_toedit";
    }
    @RequestMapping("doedit")
    @ResponseBody
    public JsonResult doedit(Category category) throws IOException {
        int i = service.editCategory(category);
        JsonResult jsonResult=new JsonResult();
        jsonResult.setData(i);
        if(i==1){
            jsonResult.setStatusCode(0);//成功
            jsonResult.setMsg("修改成功");
        }else if (i==0){
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("修改失败");
        }else {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("修改失败，类别名重复");
        }
        return jsonResult;
    }
    @RequestMapping("del/{id}")
    @ResponseBody
    public JsonResult del(@PathVariable(name = "id") Integer id) throws IOException {
        int i = service.delCategoryById(id);
        JsonResult jsonResult=new JsonResult();
        jsonResult.setData(i);
        if(i==1){
            jsonResult.setStatusCode(0);//成功
            jsonResult.setMsg("删除成功");
        }else if (i==0){
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("删除失败");
        }else {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("删除失败,该类别下还有商品不能删除");
        }
        return jsonResult;
    }
}
