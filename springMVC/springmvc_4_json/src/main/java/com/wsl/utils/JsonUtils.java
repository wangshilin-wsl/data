package com.wsl.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object,String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        //使用ObjectMapper格式化日期
        //不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);

        //objectMapper时间解析后的格式默认为Timestamp时间戳
       return mapper.writeValueAsString(object);
    }
}
