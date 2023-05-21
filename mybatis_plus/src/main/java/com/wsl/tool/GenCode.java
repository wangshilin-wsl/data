package com.wsl.tool;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName GenCode.java
 * @Description TODO
 * @createTime 2022年03月24日 19:22:00
 */
//代码自动生成器
public class GenCode {
    public static void main(String[] args) {
        //  需要构建一个代码生成器对象

        AutoGenerator generator = new AutoGenerator();

        //配置策略

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("wsl");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);//是否覆盖原来相同名字的文件夹
        gc.setServiceName("%sService");//service
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);//自动配置swagger文档
        generator.setGlobalConfig(gc);

        //2、设置数据源
        final DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        dsc.setUsername("root");
        dsc.setPassword("wangshilin");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");

        generator.setDataSource(dsc);

        //3、包的配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("blog");
        pc.setParent("com.wsl");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        generator.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("book", "user");//设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);//自动生成lombok
        strategy.setLogicDeleteFieldName("deleted");//逻辑删除
        //自动填充
        TableFill insert = new TableFill("create_time", FieldFill.INSERT);
        TableFill update = new TableFill("update_time", FieldFill.UPDATE);
        final ArrayList<TableFill> list = new ArrayList<>();
        list.add(insert);
        list.add(update);
        strategy.setTableFillList(list);
        //乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);// localhost:8080/hello_id_2

        generator.setStrategy(strategy);

        generator.execute();
    }
}
