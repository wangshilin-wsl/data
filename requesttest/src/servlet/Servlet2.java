package servlet;

import model.dao.UserDao;
import model.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User(userName,password);
        UserDao userDao=new UserDao();
        boolean ret= userDao.insert(user);
        if(ret){
            //request.getRequestDispatcher("/HTML/third.jsp").forward(request,response);
            response.sendRedirect("/job6/HTML/third.jsp");
        }else{
            response.sendRedirect("/job6/HTML/first.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
