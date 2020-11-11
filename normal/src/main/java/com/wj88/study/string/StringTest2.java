package com.wj88.study.string;

/**
 * StringTest2
 * @description TODO
 * @author huayu
 * @date 2020/10/20 10:06
 * @version 1.0
 */
public class StringTest2 {

    public static void main(String[] args) {
        String s ="（其间：2012.03—2014.12 中山大学法律硕士毕业）";

        System.out.println(s.indexOf("—"));
        System.out.println(s.substring(s.indexOf("—")-7,s.length()-1));
    }
}
