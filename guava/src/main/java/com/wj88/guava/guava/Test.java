package com.wj88.guava.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * Test
 *
 * @author huayu
 * @date 2020/7/29 14:28
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {
        test3();
    }

    public static void test(){
        // 普通Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        Map<String, String> map = Maps.newHashMap();

        // 不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");
    }

    public static void test1(){
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        map.put("aa", list);
        System.out.println(map.get("aa"));//[1, 2]

        Multimap<String,Integer> map1 = ArrayListMultimap.create();
        map1.put("aa", 1);
        map1.put("aa", 2);
        System.out.println(map1.get("aa"));  //[1, 2]
    }

    public static void test2(){
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String str = "";
        for(int i=0; i<list.size(); i++){
            str = str + "-" +list.get(i);
        }

        String result = Joiner.on("-").join(list);//aa-bb-cc
    }

    public static void test3(){
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");
        System.out.println("logfileMap:"+logfileMap);//{1=a.log, 2=b.log, 3=c.log}
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);//{a.log=1, b.log=2, c.log=3}
    }

    public static void test4(){
        List<String> list = new ArrayList<String>();
        String a = "1-2-3-4-5-6";
        String[] strs = a.split("-");
        for(int i=0; i<strs.length; i++){
            list.add(strs[i]);
        }

        String str = "1-2-3-4-5-6";
        List<String> list2 = Splitter.on("-").splitToList(str);
        System.out.println(list2);//[1, 2, 3, 4, 5, 6]

        String str1 = "1-2-3-4-  5-  6   ";
        List<String> list3 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str1);
        System.out.println(list3);//[1, 2, 3, 4, 5, 6]

        String str2 = "aa=11,bb=23";
        Map<String,String> map = Splitter.on(",").withKeyValueSeparator("=").split(str2);
        System.out.println(map);//{aa=11, bb=23}

        String str3 = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(str3);
        System.out.println(result);//[aa, dd, ff]
    }
}
