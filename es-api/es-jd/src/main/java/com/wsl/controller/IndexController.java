package com.wsl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @createTime 2022年08月19日 23:28:00
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }
}
