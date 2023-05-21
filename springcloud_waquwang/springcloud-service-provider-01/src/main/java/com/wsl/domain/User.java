package com.wsl.domain;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2023年02月22日 21:48:00
 */
public class User {
    private Integer id;
    private String name;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
