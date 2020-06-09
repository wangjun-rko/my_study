package com.wj88.myexception.classError;

/**
 * Test
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/8/7 9:05
 */
public class Test {
    public static void main(String[] args) {
        int k = M.i;
        M.t();
    }

}

class M {
    static int i = 1 / 0;

    public static void t() {
        System.out.println("1");
    }
}
