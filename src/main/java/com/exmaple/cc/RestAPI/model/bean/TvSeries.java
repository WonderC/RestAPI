package com.exmaple.cc.RestAPI.model.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TvSeries {

    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 总数
     */
    private int count;
    /**
     * 发布日期
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date originRelease;

    public TvSeries() {

    }

    /**
     * return
     * @param id
     * @param name
     * @param count
     * @param originRelease
     */
    public TvSeries(int id, String name, int count, Date originRelease) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.originRelease = originRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"{id:" + id + ";name=" + name + "}";
    }
}
