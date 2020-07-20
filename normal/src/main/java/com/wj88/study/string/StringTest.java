package com.wj88.study.string;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StringTest
 *
 * @author huayu
 * @version 1.0
 * @description 字符串
 * @date 2019/5/24 16:53
 */
public class StringTest {

    public static void main(String[] args) {
        //String a = new String("wj");
        //String b = a.intern();
        //System.out.println(a==a.intern());// false
        //System.out.println(b==a.intern());// true
        //try {
        //    System.out.println(new String(Base64.decodeBase64("5p+l6K+i5oiQ5Yqf".getBytes()), "UTF-8"));
        //} catch (UnsupportedEncodingException e) {
        //    e.printStackTrace();
        //}
        BigDecimal.valueOf(1949293.98).divide(BigDecimal.valueOf(10000), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(1949293.98/10000);
        int m = BigDecimal.valueOf(1949293.98).divide(BigDecimal.valueOf(10000), 0, BigDecimal.ROUND_HALF_UP).intValue();
        //System.out.println(m);
        //System.out.println(m+m/10*2);
        //System.out.println((233+233%6)/6);
        //System.out.println(238/6);
        //System.out.println(38*6);
        //System.out.println(39*6);

        Map<Integer, BigDecimal> valueMap = new LinkedHashMap<>();
        valueMap.put(1,BigDecimal.valueOf(569.35));
        valueMap.put(3,BigDecimal.valueOf(579.35));
        valueMap.put(4,BigDecimal.valueOf(599.35));
        valueMap.put(5,BigDecimal.valueOf(669.35));
        valueMap.put(8,BigDecimal.valueOf(869.35));

        Integer yf = valueMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst().get().getKey();

        //System.out.println(yf);

        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_DOWN));
        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_DOWN).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)));
        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(BigDecimal.valueOf(940000.00).divide(BigDecimal.valueOf(1240000.00), 4, BigDecimal.ROUND_HALF_DOWN).multiply(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP));

        //System.out.println(BigDecimal.valueOf(0.7581).multiply(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP));

        List<BigDecimal> value= new ArrayList<>();
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0.00));
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0.00));
        value.add(BigDecimal.valueOf(0.00));
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0));
        value.add(BigDecimal.valueOf(0));

        //System.out.println(value);

        //value=test(2020,value);


        //System.out.println(value);

        //System.out.println(Integer.getInteger("1"));
        //System.out.println(new Integer("1"));

        String[] unitArray = {"广州市人民检察院", "荔湾区人民检察院", "海珠区人民检察院", "天河区人民检察院", "白云区人民检察院", "黄浦区人民检察院", "番禺区人民检察院",
                "花都区人民检察院", "南沙区人民检察院", "从化区人民检察院", "增城区人民检察院", "越秀区人民检察院"};


    }

    protected static List<BigDecimal> test(int nd, List<BigDecimal> valueList) {
        LocalDate local = LocalDate.now();
        int year = local.getYear();
        int size = valueList.size();
        if (nd == year) {
            System.out.println(size);
            for (int i = size - 1; i >= 0; i--) {
                if (!valueList.get(i).toString().equals("0")) {
                    size = i+1;
                    break;
                }
            }
            System.out.println(size);
            valueList = valueList.subList(0,size);
        }
        // 每月累计支出为0 设置为前一个月的累计支出
        BigDecimal tmp = BigDecimal.valueOf(0);
        for (int i = 0; i < size; i++) {
            if (valueList.get(i).compareTo(BigDecimal.valueOf(0)) == 0) {
                valueList.set(i, tmp);
            } else {
                tmp = valueList.get(i);
            }
        }
        return valueList;
    }

}
