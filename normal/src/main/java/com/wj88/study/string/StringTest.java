package com.wj88.study.string;


import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

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
        String a = new String("wj");
        String b = a.intern();
        System.out.println(a==a.intern());// false
        System.out.println(b==a.intern());// true
        try {
            System.out.println(new String(Base64.decodeBase64("5p+l6K+i5oiQ5Yqf".getBytes()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
