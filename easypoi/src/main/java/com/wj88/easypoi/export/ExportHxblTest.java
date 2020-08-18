package com.wj88.easypoi.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;

/**
 * ExportHxblTest
 *
 * @author huayu
 * @date 2020/8/5 17:31
 * @version 1.0
 */
public class ExportHxblTest {

    public static void main(String[] args) {
        testMy2();
    }

    public static void test2() {
        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp2.xls", true);
        // 表头定义 可以将表头配置在数据库中，然后在代码里动态生成表头
        // 这里只是展示如何用代码生成表头
        List<ExcelExportEntity> columnList = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity colEntity1 = new ExcelExportEntity("序号", "id");
        colEntity1.setNeedMerge(true);
        columnList.add(colEntity1);

        ExcelExportEntity colEntity2 = new ExcelExportEntity("班级", "class");
        colEntity2.setNeedMerge(true);
        columnList.add(colEntity2);

        ExcelExportEntity yhxxGroup = new ExcelExportEntity("用户信息", "yhxx");
        List<ExcelExportEntity> yyxxList = new ArrayList<ExcelExportEntity>();
        yyxxList.add(new ExcelExportEntity("姓名", "name"));
        yyxxList.add(new ExcelExportEntity("年龄", "age"));
        yyxxList.add(new ExcelExportEntity("性别", "sex"));
        yhxxGroup.setList(yyxxList);
        columnList.add(yhxxGroup);

        // 数据拉取 一般需要从数据库中拉取
        // 这里是手动模拟数据
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> values = new HashMap<>();
            values.put("id", i);
            values.put("class", "班级" + i);

            List<Map<String, Object>> yhxxList = new ArrayList<Map<String, Object>>();
            Map<String, Object> yhxxMap = new HashMap<String, Object>();
            yhxxMap.put("name", "姓名" + i);
            yhxxMap.put("age", "年龄" + i);
            yhxxMap.put("sex", "性别" + i);
            yhxxList.add(yhxxMap);

            values.put("yhxx", yhxxList);
            dataList.add(values);
        }
        ExportParams exportParams = new ExportParams("班级信息", "人员数据");
        // Workbook workbook = ExcelExportUtil.exportExcel(params, columnList, dataList);
    }

    public static void test() {
        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp2.xls", true);
        params.setColForEach(true);

        Map<String, Object> value = new HashMap<String, Object>();

        List<Map<String, Object>> colList = new ArrayList<Map<String, Object>>();
        // 先处理表头
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "小明挑战");
        map.put("zq", "正确");
        map.put("cw", "错误");
        map.put("tj", "统计");
        map.put("zqmk", "t.zq_xm");
        map.put("cwmk", "t.cw_xm");
        map.put("tjmk", "t.tj_xm");
        colList.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "小红挑战");
        map.put("zq", "正确");
        map.put("cw", "错误");
        map.put("tj", "统计");
        map.put("zqmk", "n:t.zq_xh");
        map.put("cwmk", "n:t.cw_xh");
        map.put("tjmk", "n:t.tj_xh");
        colList.add(map);

        value.put("colList", colList);

        List<Map<String, Object>> valList = new ArrayList<Map<String, Object>>();
        map = new HashMap<String, Object>();
        map.put("one", "运动");
        map.put("two", "跑步");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);
        map = new HashMap<String, Object>();
        map.put("one", "运动");
        map.put("two", "跳高");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);
        map = new HashMap<String, Object>();
        map.put("one", "文化");
        map.put("two", "数学");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);

        value.put("valList", valList);

        Workbook book = ExcelExportUtil.exportExcel(params, value);
        File savefile = new File("D:/log/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream("D:/log/test222.xls");) {
            book.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp2.xls", true);
        params.setColForEach(true);

        Map<String, Object> value = new HashMap<String, Object>();

        List<Map<String, String>> colList = new ArrayList<>();
        // 先处理表头
        Map<String, String> map = new HashMap<>();
        map.put("name", "2019");
        map.put("user", "t.2019");
        colList.add(map);

        map = new HashMap<String, String>();
        map.put("name", "2018");
        map.put("user", "t.2018");
        colList.add(map);

        map = new HashMap<String, String>();
        map.put("name", "2017");
        map.put("user", "t.2017");
        colList.add(map);

        value.put("colList", colList);

        List<Map<String, String>> valList = new ArrayList<>();
        map = new HashMap<String, String>();
        map.put("bh", "1");
        map.put("2019", "张三");
        map.put("2018", "李四");
        map.put("2017", "张三");
        valList.add(map);
        map = new HashMap<String, String>();
        map.put("bh", "2");
        map.put("2019", "李四");
        map.put("2018", "张三");
        map.put("2017", "李四");
        valList.add(map);

        value.put("valList", valList);

        Workbook book = ExcelExportUtil.exportExcel(params, value);
        File savefile = new File("D:/log/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream("D:/log/test222.xls");) {
            book.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testMy() {

        List<NdEntity> ndEntityList = new ArrayList<>();

        ndEntityList.add(new NdEntity(2017, "小1"));
        ndEntityList.add(new NdEntity(2017, "小2"));
        ndEntityList.add(new NdEntity(2017, "小3"));
        ndEntityList.add(new NdEntity(2017, "小4"));

        ndEntityList.add(new NdEntity(2019, "小1"));
        ndEntityList.add(new NdEntity(2019, "小2"));
        ndEntityList.add(new NdEntity(2019, "小6"));

        ndEntityList.add(new NdEntity(2018, "小1"));
        ndEntityList.add(new NdEntity(2018, "小5"));
        ndEntityList.add(new NdEntity(2018, "小3"));
        ndEntityList.add(new NdEntity(2018, "小6"));

        ndEntityList = ndEntityList.stream().sorted(Comparator.comparing(NdEntity::getNd).reversed()).collect(Collectors.toList());

        //Map<Integer, List<NdEntity>> map = ndEntityList.stream().collect(Collectors.groupingBy(NdEntity::getNd));

        //System.out.println(map);

        LinkedHashMap<Integer, List<NdEntity>> map = ndEntityList.stream()
            .collect(Collectors.groupingBy(NdEntity::getNd, LinkedHashMap::new, Collectors.toList()));

        System.out.println(map);

        List<Map<String, Object>> colList = new ArrayList<>();

        List<Map<String, Object>> valList = new ArrayList<>();

        AtomicInteger index = new AtomicInteger();

        for (Map.Entry<Integer, List<NdEntity>> entry : map.entrySet()) {
            Map<String, Object> headMap = new HashMap<>(16);
            headMap.put("name", String.valueOf(entry.getKey()));
            headMap.put("user", "t." + entry.getKey());
            colList.add(headMap);
            List<NdEntity> ls = entry.getValue();
            ls.stream().forEach(k -> {
                Map<String, Object> valueMap = new HashMap<>(16);
                valueMap.put("bh", String.valueOf(index.incrementAndGet()));
                valueMap.put(String.valueOf(k.getNd()), k.getUserName());
                valList.add(valueMap);
            });
        }

        System.out.println(valList);

        Map<String, Object> value = new HashMap<String, Object>(2);
        value.put("colList", colList);
        value.put("valList", valList);

        //TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp2.xls", true);
        //params.setColForEach(true);
        //
        //Workbook book = ExcelExportUtil.exportExcel(params, value);
        //
        //try (FileOutputStream fos = new FileOutputStream("D:/log/test333.xls");) {
        //    book.write(fos);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

    }

    public static void testMy2() {

        List<NdEntity> ndEntityList = new ArrayList<>();

        ndEntityList.add(new NdEntity(2017, "小1"));
        ndEntityList.add(new NdEntity(2017, "小2"));
        ndEntityList.add(new NdEntity(2017, "小3"));
        ndEntityList.add(new NdEntity(2017, "小4"));

        ndEntityList.add(new NdEntity(2019, "小1"));
        ndEntityList.add(new NdEntity(2019, "小2"));
        ndEntityList.add(new NdEntity(2019, "小6"));

        ndEntityList.add(new NdEntity(2018, "小1"));
        ndEntityList.add(new NdEntity(2018, "小5"));
        ndEntityList.add(new NdEntity(2018, "小3"));
        ndEntityList.add(new NdEntity(2018, "小6"));

        ndEntityList.add(new NdEntity(2014, "小1"));

        ndEntityList.add(new NdEntity(2013, "小6444"));
        ndEntityList.add(new NdEntity(2013, "小65555"));

        ndEntityList = ndEntityList.stream().sorted(Comparator.comparing(NdEntity::getNd).reversed()).collect(Collectors.toList());

        LinkedHashMap<Integer, List<NdEntity>> map = ndEntityList.stream()
                .collect(Collectors.groupingBy(NdEntity::getNd, LinkedHashMap::new, Collectors.toList()));

        List<Map<String, Object>> colList = new ArrayList<>();

        List<Map<String, Object>> valList = new ArrayList<>();

        //计算行数
        int row_size = 0;
        for (Map.Entry<Integer, List<NdEntity>> entry : map.entrySet()) {
            row_size=entry.getValue().size()>row_size?entry.getValue().size():row_size;
            Map<String, Object> headMap = new HashMap<>(16);
            headMap.put("name", String.valueOf(entry.getKey()));
            headMap.put("user", "t." + entry.getKey());
            colList.add(headMap);
        }

        for (int i=1;i<=row_size;i++){
            Map app = new HashMap();
            app.put("bh",String.valueOf(i));
            int listIndex = i-1;
            for (Map.Entry<Integer, List<NdEntity>> entry : map.entrySet()) {
                List<NdEntity> ter = entry.getValue();
                if (ter.size()>listIndex) {
                    app.put(String.valueOf(ter.get(listIndex).getNd()), ter.get(listIndex).getUserName());
                }
            }
            //System.out.println(app);
            valList.add(app);
        }

        Map<String, Object> value = new HashMap<String, Object>(2);
        value.put("colList", colList);
        value.put("valList", valList);

        TemplateExportParams params = new TemplateExportParams("D:/log/exportTemp2.xls", true);
        params.setColForEach(true);

        Workbook book = ExcelExportUtil.exportExcel(params, value);

        try (FileOutputStream fos = new FileOutputStream("D:/log/test333.xls");) {
            book.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
