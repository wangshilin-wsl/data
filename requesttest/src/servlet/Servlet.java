package servlet;

import model.dao.UserDao;
import model.vo.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("UTF-8");
     response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String  userName = request.getParameter("username");
        String  password = request.getParameter("password");
        User user=new User(userName,password);
        UserDao userDao=new UserDao();
        boolean ret= userDao.checkUser(user);
        if(ret){
            session.setAttribute("name",userName);
           //request.getRequestDispatcher("/HTML/third.jsp").forward(request,response);
            response.sendRedirect("/job6/HTML/third.jsp");
        }else{
            session.setAttribute("ERROR","用户名或密码错误！！！");
            response.sendRedirect("/job6/HTML/second.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
