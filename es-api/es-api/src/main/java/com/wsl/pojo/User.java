package com.wsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年08月19日 22:13:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
}
