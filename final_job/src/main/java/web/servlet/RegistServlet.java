package web.servlet;

import pojo.User;
import service.DaoUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User(userName,password);

        boolean ret= DaoUser.insert(user);
        if(ret){
            request.getSession().setAttribute("name",userName);
            //request.getRequestDispatcher("/HTML/third.jsp").forward(request,response);
            response.sendRedirect("/final_job/jsp/third.jsp");
        }else{
            request.getSession().setAttribute("cuowu","用户名已存在！！");
            response.sendRedirect("/final_job/jsp/first.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
