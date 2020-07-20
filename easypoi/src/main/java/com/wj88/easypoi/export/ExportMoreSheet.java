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

        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp.xls", true);

        //params.setHeadingRows(2);
        //params.setHeadingStartRow(2);
        //params.setStyle(ExcelStyleType.BORDER.getClazz());

        Map<String, Object> oneMap = new HashMap<>(8);
        //oneMap.put(ExcelCssConstant.SHEET_NAME, "啊啊测试SHeet" );
        oneMap.put("name","2222");

        Map<String, Object> twoMap = new HashMap<>(8);
        //twoMap.put(ExcelCssConstant.SHEET_NAME, "2222啊啊测试SHeet" );
        twoMap.put("name","33333");

        Map<Integer, Map<String, Object>> map = new HashMap<>(8);
        map.put(0, oneMap);
        map.put(1, twoMap);

        Workbook book = ExcelExportUtil.exportExcel(map, params);
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

}
