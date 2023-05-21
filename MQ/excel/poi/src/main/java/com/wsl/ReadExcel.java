package com.wsl;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;

import static org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType.FORMULA;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ReadExcel.java
 * @Description TODO
 * @createTime 2022年09月06日 22:40:00
 */
public class ReadExcel {
    String PATH = "C:\\Users\\王世林\\Downloads\\框架\\excel\\excel文件\\";
    @Test
    public void read03() throws Exception {


        //获取文件流
        final FileInputStream inputStream = new FileInputStream(PATH + "观众统计表03.xls");
        //1、创建一个工作簿
        Workbook workbook = new HSSFWorkbook(inputStream);

        final Sheet sheet = workbook.getSheetAt(0);

        final Row row = sheet.getRow(0);

        final Cell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());
        inputStream.close();


    }

    @Test
    public void read07() throws Exception {


        //获取文件流
        final FileInputStream inputStream = new FileInputStream(PATH + "观众统计表07.xlsx");
        //1、创建一个工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);

        final Sheet sheet = workbook.getSheetAt(0);

        final Row row = sheet.getRow(0);

        final Cell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());
        inputStream.close();
    }

    @Test
    public void read08() throws Exception {


        //获取文件流
        final FileInputStream inputStream = new FileInputStream(PATH + "观众统计表03.xls");
        //1、创建一个工作簿
        Workbook workbook = new HSSFWorkbook(inputStream);

        final Sheet sheet = workbook.getSheetAt(0);

        final Row row = sheet.getRow(4);
        final Cell cell = row.getCell(0);

        //拿到计算公式
        FormulaEvaluator evaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);

        int type = cell.getCellType();
        switch (type){
            case FORMULA:
                String f = cell.getCellFormula();
                System.out.println(f);
                final CellValue evaluate = evaluator.evaluate(cell);
                final String formatAsString = evaluate.formatAsString();
        }


    }

    @Test
    public void testFormula() throws Exception{
        // 获取文件流
        FileInputStream fileInputStream = new FileInputStream(PATH + "公式.xls");
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        Row row=sheet.getRow(4);
        Cell cell=row.getCell(0);
        // 拿到计算公式eval
        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
        // 输出单元格的内容
        int cellType = cell.getCellType();
        switch (cellType){
            case FORMULA:
                String formula = cell.getCellFormula();
                System.out.println(formula);
                // 计算
                CellValue evaluate = formulaEvaluator.evaluate(cell);
                String cellValue = evaluate.formatAsString();
                System.out.println(cellValue);
                break;
        }
        fileInputStream.close();
    }
}
