package com.example.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateTest
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2020/6/1 14:36
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        Date nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-05-10 12:23:59");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-05-11 08:59:30");
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        System.out.println(day + "天" + hour + "小时" + min + "分钟" + sec +"秒");
    }
}
