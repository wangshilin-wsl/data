package com.wsl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Book.java
 * @Description TODO
 * @createTime 2021年11月14日 13:34:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
@Builder
public class Book extends Model<Book> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_id")
    private Integer userId;
    @TableField("book_name")
    private String bookName;
}
