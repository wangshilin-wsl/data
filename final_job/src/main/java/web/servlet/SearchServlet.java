package web.servlet;

import pojo.Good;
import service.DaoGood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String search=request.getParameter("search");
        List<Good> list= DaoGood.getGoodsLike(search);
        request.getSession().setAttribute("detail",list);
        //request.getRequestDispatcher("/HTML/third.jsp").forward(request,response);
        response.sendRedirect("/final_job/jsp/search.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
