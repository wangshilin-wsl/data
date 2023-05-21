package com.wsl.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Dept.java
 * @Description 实体类
 * @createTime 2022年04月03日 13:15:00
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    /**
     * 主键
     */
    private Long deptno;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 标识来自哪个数据库的字段，同一个信息可能存在不同的数据库
     */
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
