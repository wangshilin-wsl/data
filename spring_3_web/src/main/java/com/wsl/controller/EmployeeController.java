package com.wsl.controller;

import com.wsl.dao.DepartmentDao;
import com.wsl.dao.EmployeeDao;
import com.wsl.pojo.Department;
import com.wsl.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
   @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
       return "emp/add";
    }
    @PostMapping("/emp")
    public String add(Employee employee){
        employeeDao.save(employee);//调用底层方法保存员工信息
        System.out.println(employee.toString());
        return "redirect:/emps";
    }
    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
        return "emp/update";
    }
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
       employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")int id){
       employeeDao.delete(id);
        return "redirect:/emps";
    }
}
