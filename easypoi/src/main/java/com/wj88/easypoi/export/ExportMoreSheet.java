package com.wj88.easypoi.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelStyleType;
import cn.afterturn.easypoi.excel.html.entity.ExcelCssConstant;

/**
 * ExportMoreSheet
 * 
 * @description 导出到多个sheet
 * @author huayu
 * @date 2020/7/20 15:30
 * @version 1.0
 */
public class ExportMoreSheet {

    public static void main(String[] args) {
        //testOne();
        testMore();
        String tmp = "template/excel/zsbg/全院信息表.xls";
    }

    public static void testOne(){
        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp.xls", true);
        // 标题开始行
        //params.setHeadingStartRow(0);
        // 标题行数
        //params.setHeadingRows(1);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        //params.setSheetName("班级信息");
        //params.setTempParams("t");

        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i=0;i<4;i++){
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("bh", i + 1 + "");
            lm.put("ne", i + 1 + "name");
            listMap.add(lm);
        }

        //params.setHeadingRows(2);
        //params.setHeadingStartRow(2);
        //params.setStyle(ExcelStyleType.BORDER.getClazz());

        Map<String, Object> oneMap = new HashMap<>(8);
        //oneMap.put(ExcelCssConstant.SHEET_NAME, "啊啊测试SHeet" );
        oneMap.put("name","2222");
        oneMap.put("mp",listMap);

        Map<String, Object> twoMap = new HashMap<>(8);
        //twoMap.put(ExcelCssConstant.SHEET_NAME, "2222啊啊测试SHeet" );
        twoMap.put("name","33333");
        twoMap.put("maplist",listMap);

        Map<Integer, Map<String, Object>> map = new HashMap<>(8);
        map.put(1, oneMap);
        //map.put(2, twoMap);

        //Workbook book = ExcelExportUtil.exportExcel(map, params);
        Workbook book = ExcelExportUtil.exportExcel(params,oneMap);
        //Workbook book = ExcelExportUtil.exportExcel(params,twoMap);
        File savefile = new File("D:/log/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream("D:/log/test.xls");) {
            book.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testMore(){
        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp.xls", true);
        // 标题开始行
        //params.setHeadingStartRow(0);
        // 标题行数
        //params.setHeadingRows(1);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        //params.setSheetName("班级信息");
        //params.setTempParams("t");

        String[] sheetNameArray = {"11","22"} ;
        params.setSheetName(sheetNameArray);

        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i=0;i<4;i++){
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("bh", i + 1 + "");
            lm.put("ne", i + 1 + "name");
            listMap.add(lm);
        }

        List<Map<String, Object>> numOneList = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name","2222");
        map1.put("mp",listMap);
        map1.put("mp2",listMap);

        Workbook book = ExcelExportUtil.exportExcel(params,map1);
        File savefile = new File("D:/log/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream("D:/log/test.xls");) {
            book.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
