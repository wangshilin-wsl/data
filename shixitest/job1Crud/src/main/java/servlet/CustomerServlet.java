package servlet;

import com.alibaba.fastjson.JSON;
import pojo.Customer;
import pojo.Employee;
import service.CustomerService;
import utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/jsp/docust")
public class CustomerServlet extends HttpServlet {
    CustomerService service= ServiceFactory.getCustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op=request.getParameter("op");
        System.out.println(op);
        if("doadd".equals(op)){
            doAdd(request,response);
        }else if("search".equals(op)){
            search(request,response);
        }else if("delete".equals(op)){
            delete(request,response);
        }else if("update".equals(op)){
            update(request,response);
        }
        else if("update1".equals(op)){
            update1(request,response);
        } else if("manydel".equals(op)){
            manydel(request,response);
        }
    }

    private void manydel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] custids = request.getParameterValues("custids[]");
        Map<String,Object> map=new HashMap<>();
        try {
            int i =service.manyDel(custids);
            map.put("result",i);
            if(i>0){
                map.put("msg","删除成功");
            }else {
                map.put("msg","删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        String jsonString = JSON.toJSONString(map);
        response.getWriter().write(jsonString);
    }

    private void update1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map=new HashMap<>();
        int custid=Integer.parseInt(request.getParameter("custid"));
        String  custname=request.getParameter("custname");
        String  contacts=request.getParameter("contacts");
        System.out.println(contacts);
        String  tel=request.getParameter("tel");
        String  email=request.getParameter("email");
        Employee emp=(Employee)request.getSession().getAttribute("emp");
        Customer cust=new Customer(custid,custname,contacts,tel,email,emp.getEmpid());
        int i = 0;
        try {
            i = service.updateCustomer(cust);
            map.put("result",i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(i>0) {
            map.put("msg","修改成功");
        }else if(i==0){
            map.put("msg","修改失败");
        }else{
            map.put("msg","修改失败,客户名已经存在");
        }
        String jsonString = JSON.toJSONString(map);
        response.getWriter().write(jsonString);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String custid=request.getParameter("custid");
        try {
            Customer customer = service.searchById(Integer.parseInt(custid));
            String jsonString = JSON.toJSONString(customer);
            response.getWriter().write(jsonString);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String custid=request.getParameter("custid");
        Map<String,Object> map=new HashMap<>();
        try {
            int i = service.deleteCustomer(Integer.parseInt(custid));
            map.put("result",i);
            if(i>0){
                map.put("msg","删除成功");
            }else {
                map.put("msg","删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        String jsonString = JSON.toJSONString(map);
        response.getWriter().write(jsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Employee emp=(Employee)request.getSession().getAttribute("emp");

        String custname=request.getParameter("name");
        System.out.println(custname);
        List<Customer> list = null;
        int pagesize=2;
        int pageindex=1;
        String pagestr = request.getParameter("pageindex");
        if(pagestr!=null&&!"".equals(pagestr)){
            pageindex=Integer.parseInt(pagestr);
        }
        Customer customer=new Customer();
        customer.setCustname(custname);
        customer.setEmpid(emp.getEmpid());
        System.out.println(customer);
        int pagecount=0;
        try {
            list = service.search(customer,pageindex,pagesize);
            pagecount = service.getPageCountByCust(customer, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      /*  for (Customer c:list) {
            System.out.println(c);
        }*/
        request.setAttribute("pagecount",pagecount);
        request.setAttribute("pageindex",pageindex);
      request.setAttribute("condition",customer);
        request.setAttribute("custs",list);

        Map<String,Object> map=new HashMap<>();
        map.put("datas",list);
        map.put("pagecount",pagecount);
        String json = JSON.toJSONString(map);
        System.out.println(json);
        response.getWriter().write(json);
       // request.getRequestDispatcher("/jsp/cust_list.html").forward(request,response);
    }
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String  custname=request.getParameter("custname");
        String  contacts=request.getParameter("contacts");
        String  tel=request.getParameter("tel");
        String  email=request.getParameter("email");
        Employee emp=(Employee)request.getSession().getAttribute("emp");
        Customer cust=new Customer(custname,contacts,tel,email,emp.getEmpid());
        int i = 0;
        try {
            i =service.addCustomer(cust);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(i);
        Map<String,Object> map=new HashMap<>();
        map.put("result",i);
        if(i>0) {
            map.put("msg","添加成功");
        }else if(i==0){
            map.put("msg","添加失败");
        }else{
            map.put("msg","添加失败,客户名已经存在");
        }
        String jsonString = JSON.toJSONString(map);
        response.getWriter().write(jsonString);
    }

}
