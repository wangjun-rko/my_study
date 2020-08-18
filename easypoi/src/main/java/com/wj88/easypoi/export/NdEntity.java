package com.wj88.easypoi.export;

/**
 * NdEntity
 *
 * @author huayu
 * @date 2020/8/6 8:24
 * @version 1.0
 */
public class NdEntity {

    private Integer nd;

    private String userName;

    public NdEntity(Integer nd, String userName) {
        this.nd = nd;
        this.userName = userName;
    }

    public Integer getNd() {
        return nd;
    }

    public String getUserName() {
        return userName;
    }
}
