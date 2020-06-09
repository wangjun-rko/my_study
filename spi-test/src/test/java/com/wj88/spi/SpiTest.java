package com.wj88.spi;

import java.util.ServiceLoader;

import org.junit.Test;

/**
 * SpiTest
 *
 * @author huayu
 * @version 1.0
 * @description SpiTest
 * @date 2020/4/14 17:56
 */
public class SpiTest {

    @Test
    public void testGetName(){
        ServiceLoader<ICar> serviceLoader = ServiceLoader.load(ICar.class);
        serviceLoader.forEach(ICar::getName);
    }
}
