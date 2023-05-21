package com.wsl.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2021年10月31日 16:31:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("email")
    private String email;
    @TableField("version")
    // 乐观锁的versioin注解
    @Version
    private Integer version;
    //逻辑删除注解
    @TableLogic
    @TableField("deleted")
    private Integer deleted;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value ="update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
