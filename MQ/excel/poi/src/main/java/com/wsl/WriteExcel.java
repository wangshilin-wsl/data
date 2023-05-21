package com.wsl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @ClassName WriteExcel.java
 * @author WSL
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年09月06日 22:12:00
 */
public class WriteExcel {
  String PATH = "C:\\Users\\王世林\\Downloads\\框架\\excel\\excel文件\\";
  /**
   * @methodName test1
   * @Author WSL
   * @Description  测试03版excel
   * @Date 22:36 2022/9/6
   * @Param 
   * @return void
   **/
  @Test
  public void test1() throws Exception {
      //1、创建一个工作簿
    Workbook workbook = new HSSFWorkbook();
    //2、创建工作表
    Sheet sheet1 = workbook.createSheet("统计表");
    //3、创建行
    Row row1 = sheet1.createRow(0);
    //4、创建一个单元格
    Cell cell11 = row1.createCell(0);
    cell11.setCellValue("今日新增观众");
    Cell cell12 = row1.createCell(1);
    cell12.setCellValue("666");

    Row row2 = sheet1.createRow(1);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("统计时间");
    Cell cell22 = row2.createCell(1);
    cell22.setCellValue("统计时间");
    cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

    //生成表io流
    FileOutputStream stream = new FileOutputStream(PATH + "观众统计表03.xls");
    workbook.write(stream);
    stream.close();
    System.out.println("文件生成完毕");
  }
  /**
   * @methodName test2
   * @Author WSL
   * @Description  测试07版excel
   * @Date 22:36 2022/9/6
   * @Param
   * @return void
   **/
  @Test
  public void test2() throws Exception {
    //1、创建一个工作簿
    Workbook workbook = new XSSFWorkbook();
    //2、创建工作表
    Sheet sheet1 = workbook.createSheet("统计表");
    //3、创建行
    Row row1 = sheet1.createRow(0);
    //4、创建一个单元格
    Cell cell11 = row1.createCell(0);
    cell11.setCellValue("今日新增观众");
    Cell cell12 = row1.createCell(1);
    cell12.setCellValue("666");

    Row row2 = sheet1.createRow(1);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("统计时间");
    Cell cell22 = row2.createCell(1);
    cell22.setCellValue("统计时间");
    cell22.setCellValue(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

    //生成表io流
    FileOutputStream stream = new FileOutputStream(PATH + "观众统计表07.xlsx");
    workbook.write(stream);
    stream.close();
    System.out.println("文件生成完毕");
  }
  /**
   * @methodName test3
   * @Author WSL
   * @Description  测试03版excel生成大数据
   * @Date 22:36 2022/9/6
   * @Param
   * @return void
   **/
  @Test
  public void test3() throws Exception {
    long begin = System.currentTimeMillis();
    //1、创建一个工作簿
    Workbook workbook = new HSSFWorkbook();
    //2、创建工作表
    Sheet sheet1 = workbook.createSheet("统计表");
    for (int rowNum = 0; rowNum < 65536; rowNum++) {
      Row row = sheet1.createRow(rowNum);
      for (int colNum = 0; colNum < 10; colNum++) {
        final Cell cell = row.createCell(colNum);
        cell.setCellValue(colNum);
      }
    }

    //生成表io流
    FileOutputStream stream = new FileOutputStream(PATH + "大数据03.xls");
    workbook.write(stream);
    stream.close();
    long end = System.currentTimeMillis();
    System.out.println(end - begin);
    System.out.println("文件生成完毕");
  }
  /**
   * @methodName test4
   * @Author WSL
   * @Description  测试07版excel生成大数据
   * @Date 22:36 2022/9/6
   * @Param
   * @return void
   **/
  @Test
  public void test4() throws Exception {
    long begin = System.currentTimeMillis();
    //1、创建一个工作簿
    Workbook workbook = new XSSFWorkbook();
    //2、创建工作表
    Sheet sheet1 = workbook.createSheet("统计表");
    for (int rowNum = 0; rowNum < 65537; rowNum++) {
      Row row = sheet1.createRow(rowNum);
      for (int colNum = 0; colNum < 10; colNum++) {
        final Cell cell = row.createCell(colNum);
        cell.setCellValue(colNum);
      }
    }

    //生成表io流
    FileOutputStream stream = new FileOutputStream(PATH + "大数据07.xlsx");
    workbook.write(stream);
    stream.close();
    long end = System.currentTimeMillis();
    System.out.println(end - begin);
    System.out.println("文件生成完毕");
  }
  /**
   * @methodName test5
   * @Author WSL
   * @Description  测试07版快速excel
   * @Date 22:36 2022/9/6
   * @Param
   * @return void
   **/
  @Test
  public void test5() throws Exception {
    long begin = System.currentTimeMillis();
    //1、创建一个工作簿
    Workbook workbook = new SXSSFWorkbook();
    //2、创建工作表
    Sheet sheet1 = workbook.createSheet("统计表");
    for (int rowNum = 0; rowNum < 65537; rowNum++) {
      Row row = sheet1.createRow(rowNum);
      for (int colNum = 0; colNum < 10; colNum++) {
        final Cell cell = row.createCell(colNum);
        cell.setCellValue(colNum);
      }
    }

    //生成表io流
    FileOutputStream stream = new FileOutputStream(PATH + "大数据快速07.xlsx");
    workbook.write(stream);
    stream.close();
    //清除临时文件
    ((SXSSFWorkbook)workbook).dispose();
    long end = System.currentTimeMillis();
    System.out.println(end - begin);
    System.out.println("文件生成完毕");
  }

}
