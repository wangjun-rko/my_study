package com.example.demo.json;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

/**
 * JsonTest
 * @description TODO
 * @author huayu
 * @date 2020/9/17 17:48
 * @version 1.0
 */
public class JsonTest {

    public static void main(String[] args) {

        long[] t ={1,3,4,5};
        double[] y ={20.00,25.00,56.00};
        String[] p = {"南沙区检","天河区检"};

        MyObj obj = MyObj.builder().dqdwgdcrs(12).bydcrs(13).bydhrs(14).cydhrs(15).jznddqdhrs(16).bndzrs(t).bydzrs(t)
                .ydndzb(y).dcrs(t).dhrs(t).wdzrs(t).dqdwgjrrs(456).dyjrrs(34).dydhrs(12)
                .cyjrdqrs(23).jzndjrdqrs(12).qymc(p).dyjdrs(t).ndjdhj(t).xjdrs(t).jrrs(t).dhry(t).jrzrs(t).build();

        String str = JSON.toJSONString(obj);
        System.out.println(str);

        long[] dyjdrs = {1,22,3,4};

        System.out.println(Arrays.stream(dyjdrs).sum());
    }
}
