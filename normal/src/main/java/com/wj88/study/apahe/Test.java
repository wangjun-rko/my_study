package com.wj88.study.apahe;

import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.lang3.ArrayUtils;

/**
 * Test
 *
 * @author huayu
 * @date 2020/7/29 19:38
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        test3();
        //Integer[] replaceNull = new Integer[]{1, null, null, 3, 5};
        //int[] primitive = ArrayUtils.toPrimitive(replaceNull, 2);
        //
        //Arrays.stream(replaceNull).forEach(System.out::println);
        //Arrays.stream(primitive).forEach(System.out::println);

    }

    public static void test2(){
        String file = "test.doc";
        String[] tmp = file.split("\\.");
        System.out.println(tmp[0]);//test
        System.out.println(tmp[1]);//doc
        String str=file.substring(0,file.lastIndexOf("."));
        System.out.println(str);//test
        String str1 =file.substring(file.lastIndexOf("."));
        System.out.println(str1);//.doc
    }

    public static void test3(){
        String file = "template/excel/zsbg/全院信息表.xls";
        String str=FilenameUtils.getExtension(file);
        System.out.println(str);//doc
        String str1 =FilenameUtils.getBaseName(file);
        System.out.println(str1);//.test
        System.out.println(FilenameUtils.getName(file));
    }

    public static boolean test4(){
        String str = "";
        if (str ==null ||str=="") {
            return true;
        }
        if (str=="" ||str ==null) {
            return true;
        }
        return false;
    }
}
