package com.wsl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsComplex extends Goods {
    private Category category;
    @Override
    public String toString() {
        return super.toString()+"GoodsComplex{" +
                "category=" + category +
                '}';
    }
}
