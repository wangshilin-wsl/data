package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数，文件名称
        String filename1=request.getParameter("filename");
        //使用字节输入流加载进文件内存
        ServletContext servletContext=this.getServletContext();
       String realPath= servletContext.getRealPath("/image/"+filename1);
        FileInputStream fis=new FileInputStream(realPath);

        String type=servletContext.getMimeType(filename1);
        response.setHeader("content-type",type);
        response.setHeader("content-disposition","attachment;filename="+filename1);
        ServletOutputStream servletOutputStream=response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while((len=fis.read(buff))!=-1){
            servletOutputStream.write(buff,0,len);
        }
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
