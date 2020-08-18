package com.wj88.easypoi.export;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * ExportMoreView
 *
 * @author huayu
 * @date 2020/8/3 17:24
 * @version 1.0
 */
public class ExportMoreView {

    private List<ExportView> moreViewList= Lists.newArrayList();

    public List<ExportView> getMoreViewList() {
        return moreViewList;
    }

    public void setMoreViewList(List<ExportView> moreViewList) {
        this.moreViewList = moreViewList;
    }
}
