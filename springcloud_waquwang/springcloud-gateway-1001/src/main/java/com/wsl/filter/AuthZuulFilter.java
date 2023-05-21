package com.wsl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName AuthZuulFilter.java
 * @Description TODO
 * @createTime 2023年03月08日 20:33:00
 */
@Component
public class AuthZuulFilter extends ZuulFilter {
    //过滤器执行的位置
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否需要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //具体过滤逻辑
    @Override
    public Object run() throws ZuulException {
//        int a = 10 / 0;
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            context.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            context.setResponseBody("非法访问");
        }
        return context;
    }
}
