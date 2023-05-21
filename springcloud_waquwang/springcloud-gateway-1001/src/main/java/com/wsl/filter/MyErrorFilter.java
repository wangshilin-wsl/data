package com.wsl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MyErrorFilter.java
 * @Description TODO
 * @createTime 2023年03月10日 20:19:00
 */
//@Component
public class MyErrorFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ZuulFilter.class);
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        PrintWriter pw = null;
        try {
            RequestContext context = RequestContext.getCurrentContext();
            ZuulException exception = (ZuulException)context.getThrowable();

            logger.error("进入系统异常拦截：", exception);

            HttpServletResponse response = context.getResponse();
            response.setContentType("application/json;charset=utf8");
            response.setStatus(exception.nStatusCode);

            pw = response.getWriter();
            pw.print("异常拦截器处理类：{code:" + exception.nStatusCode + ",message:\"" + exception.getMessage() + "\"}");
        } catch (Exception e) {
            logger.error("发生异常" + e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return null;
    }
}
