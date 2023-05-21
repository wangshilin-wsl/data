package com.wsl.controller;

import com.wsl.service.ContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ContentController.java
 * @Description TODO
 * @createTime 2022年08月20日 20:27:00
 */
@RestController
public class ContentController {
    @Resource
    private ContentService contentService;
    @GetMapping("/parse/{keyword}")
    public boolean parse(@PathVariable("keyword") String keyword) throws Exception{
        return contentService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> searchPage(@PathVariable("keyword") String keyword,
                                                @PathVariable("pageNo") int pageNo,
                                                @PathVariable("pageSize") int pageSize) throws Exception{
        return contentService.searchPageHL(keyword, pageNo, pageSize);
    }
}
