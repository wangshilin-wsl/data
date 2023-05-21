package com.wsl.utils;

import com.wsl.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName HtmlParseUtil.java
 * @Description TODO
 * @createTime 2022年08月20日 20:05:00
 */
public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {
        final List<Content> contents = parseJD("Java");
        contents.forEach(System.out::println);

    }

    public static List<Content> parseJD(String keyword) throws Exception{
        //获取请求 https://search.jd.com/Search?keyword=Java
        //前提，需要联网
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        //解析网页,Jsoup返回的Document就是浏览器的Document对象
        Document document = Jsoup.parse(new URL(url), 3000);
        //所有在js中可以使用的方法在这都可以用
        Element element = document.getElementById("J_goodsList");
        //找到所有的li元素
        Elements li = element.getElementsByTag("li");
        //这里的el就是每一个li标签
        //data-lazy-img
        List<Content> list = new ArrayList<>();
        for (Element el : li) {
            String img = el.getElementsByTag("img").get(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").get(0).text();
            String title = el.getElementsByClass("p-name").get(0).text();
            final Content content = new Content(title, img, price);
            list.add(content);
        }
        return list;
    }
}
