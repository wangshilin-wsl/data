package com.wsl;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName EasyExcel.java
 * @Description TODO
 * @createTime 2022年09月07日 22:06:00
 */
public class EasyExcelTest {
    String PATH = "C:\\Users\\王世林\\Downloads\\框架\\excel\\excel文件\\";
    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 直接写即可
     */
    /**
     * 根据参数只导出指定列
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>
     * 2. 根据自己或者排除自己需要的列
     * <p>
     * 3. 直接写即可
     *
     * @since 2.1.1
     */
    @Test
    public void excludeOrIncludeWrite() {
        String fileName = PATH + "excludeOrIncludeWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里需要注意 在使用ExcelProperty注解的使用，如果想不空列则需要加入order字段，而不是index,order会忽略空列，然后继续往后，而index，不会忽略空列，在第几列就是第几列。

        // 根据用户传入字段 假设我们只要导出 date
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("wsl" + i);
            data.setDoubleData(0.56);
            data.setDate(new Date());
            list.add(data);
        }
       EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(list);
    }

    @Test
    public void read(){
        String fileName =  PATH + "excludeOrIncludeWrite1662560600609" + ".xlsx";
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }
}
