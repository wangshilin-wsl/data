package com.wsl.vo;

import com.wsl.pojo.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName UserVO.java
 * @Description TODO
 * @createTime 2021年11月14日 13:43:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private List<Book> books;
}
