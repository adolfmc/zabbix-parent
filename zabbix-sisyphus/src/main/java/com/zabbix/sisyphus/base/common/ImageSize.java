package com.zabbix.sisyphus.base.common;

/**
 * 作者: zabbix 创建于 16/10/27.
 */
public class ImageSize {
    private  Integer width;
    private Integer height;

    public ImageSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
