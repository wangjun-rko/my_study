package com.example.demo.json;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * MyObj
 * @description TODO
 * @author huayu
 * @date 2020/9/17 17:48
 * @version 1.0
 */
@Setter
@Getter
@Builder
public class MyObj {

    /**当前队伍共调出人数**/
    private long dqdwgdcrs;

    /**本月调出人数**/
    private long bydcrs;

    /**本月调回人数**/
    private long bydhrs;

    /**次月调回人数**/
    private long cydhrs;

    /**截止年底到期调回人数**/
    private long jznddqdhrs;

    /**人员借调类型分布 本年度外派类型总人数 调任 代理 挂职 借用 借调**/
    private long[] bndzrs;

    /**人员借调类型分布 本月度外派类型总人数 调任 代理 挂职 借用 借调**/
    private long[] bydzrs;

    /**人员借调类型分布 月度外派人员全年外派人员总数比例 调任 代理 挂职 借用 借调**/
    private double[] ydndzb;

    /**月度借调人员情况 调出人数**/
    private long[] dcrs;

    /**月度借调人员情况 调回人数**/
    private long[] dhrs;

    /**月度借调人员情况 外调中人数**/
    private long[] wdzrs;

    /**当前队伍共借入人数**/
    private long dqdwgjrrs;

    /**当月借入人数**/
    private long dyjrrs;

    /**当月调回人数**/
    private long dydhrs;

    /**次月借入到期人数**/
    private long cyjrdqrs;

    /**截止年底借入到期人数 次月到年底**/
    private long jzndjrdqrs;

    /**借入人员区院来源-区院名称**/
    private String[] qymc;

    /**借入人员区院来源-当月借调人员**/
    private long[] dyjdrs;

    /**借入人员区院来源-年度借调总计**/
    private long[] ndjdhj;

    /**借入人员区院来源-现借调人数**/
    private long[] xjdrs;

    /**月度借调人员情况-借入人员**/
    private long[] jrrs;

    /**月度借调人员情况-调回人员**/
    private long[] dhry;

    /**月度借调人员情况-借入总人数**/
    private long[] jrzrs;
}
