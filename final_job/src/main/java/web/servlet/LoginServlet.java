package web.servlet;

import pojo.User;
import service.DaoUser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String  userName = request.getParameter("username");
        String  password = request.getParameter("password");
        User user=new User(userName,password);
        boolean ret= DaoUser.check(user);
        System.out.println(ret);
        if(ret){
            session.setAttribute("name",userName);
            //request.getRequestDispatcher("/HTML/third.jsp").forward(request,response);
            response.sendRedirect("/final_job/jsp/third.jsp");
        }else{
            session.setAttribute("ERROR","用户名或密码错误！！！");
            response.sendRedirect("/final_job/jsp/second.jsp");

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
