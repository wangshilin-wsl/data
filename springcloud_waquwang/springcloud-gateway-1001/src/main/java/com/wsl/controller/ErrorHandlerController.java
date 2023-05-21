package com.wsl.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ErrorHandlerController.java
 * @Description TODO
 * @createTime 2023年03月10日 20:29:00
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    //出异常后进入该方法，交给下面的方法处理
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public String error(){
        RequestContext context = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)context.getThrowable();
        return "异常controller处理类：{code:" + exception.nStatusCode + ",message:\"" + exception.getMessage() + "\"}";
    }
}
