package com.example.demo.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * TimeTest
 * @description TODO
 * @author huayu
 * @date 2020/9/16 19:20
 * @version 1.0
 */
public class TimeTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now().minusMonths(1);
        System.out.println(now.toString());
        System.out.println(LocalDate.now());

        BigDecimal y = BigDecimal.valueOf(6);
        BigDecimal n = BigDecimal.valueOf(10);

        BigDecimal b = y.divide(n, 4, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);

        //System.out.println(b.toString());
        //
        //System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay());
        //
        //System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));
        //
        //System.out.println(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()));
        //
        //System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()));
        //
        //
        //System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()));
        //
        //System.out.println(LocalDate.now().plusMonths(1).with(TemporalAdjusters.firstDayOfMonth()));

        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(LocalDate.now().plusMonths(1).with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(dtf.format(LocalDate.now()));

        System.out.println(LocalDate.now().minusYears(1).with(TemporalAdjusters.lastDayOfYear()));

        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));

        String a = "1";
        String b2 = null;

        System.out.println(a.equals(b2));

    }
}
