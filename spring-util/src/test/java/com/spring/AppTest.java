package com.spring;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

import com.spring.excel.entity.StudentEntity;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;

/**
 * Unit test for simple App.
 */
public class AppTest {

    List<StudentEntity> list;

    @Before
    public void initData() {
        list = new ArrayList<>();
        StudentEntity entity = StudentEntity.builder().name("jeff").sex(1).birthday(new Date()).build();
        list.add(entity);
    }

    @Test
    public void exportCompanyImg() throws Exception {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), StudentEntity.class, list);
        FileOutputStream fos = new FileOutputStream("C:/Users/wangzhe01/Desktop/1.xls");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void test2() {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        File file = new File("C:\\Users\\wangzhe01\\Desktop", "1.xls");
        List<StudentEntity> list = ExcelImportUtil.importExcel(file, StudentEntity.class, params);
        System.out.println(list);
    }
}
