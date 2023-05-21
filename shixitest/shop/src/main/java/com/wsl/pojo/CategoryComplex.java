package com.wsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryComplex extends Category {
    List<Goods> goodsList;

    @Override
    public String toString() {
        return super.toString()+"CategoryComplex{" +
                "goodsList=" + goodsList +
                '}';
    }
}
