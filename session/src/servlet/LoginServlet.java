package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        //先判断验证码是够否正确
        HttpSession session = request.getSession();
        String code=(String) session.getAttribute("session");
        //删除session中的验证码
        session.removeAttribute("session");
        if( code!=null&&code.equalsIgnoreCase(checkCode)){
                //验证码正确
            if("zhangsan".equals(userName)&&"123".equals(password)){//需要查询数据库
                //存储用户信息
                session.setAttribute("user",userName);
                //重定向
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //存储提示信息
                request.setAttribute("login_error","用户名或密码错误");
                //转发
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //存储提示信息
            request.setAttribute("cc_error","验证码错误");
            //转发
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
