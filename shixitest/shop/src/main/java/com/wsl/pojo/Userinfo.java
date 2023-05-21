package com.wsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Userinfo {
    private Integer userid;
    private String username;
    private String password;
    private String realname;
}
