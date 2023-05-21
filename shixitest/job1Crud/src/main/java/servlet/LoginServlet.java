package servlet;

import lombok.SneakyThrows;
import pojo.Employee;
import service.EmployeeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);
        HttpSession session = request.getSession();
        Employee employee = new EmployeeServiceImpl().login(username, password);
        if(employee!=null){
            session.setAttribute("emp",employee);
            request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        }else{
            response.getWriter().write("<script>alert('用户名或密码错误！！！');history.go(-1);</script>");
        }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response){
    this.doPost(request,response);
    }
}
