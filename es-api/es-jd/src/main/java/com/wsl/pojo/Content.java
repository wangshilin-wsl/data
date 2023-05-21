package com.wsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Content.java
 * @Description TODO
 * @createTime 2022年08月20日 20:22:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;
}
