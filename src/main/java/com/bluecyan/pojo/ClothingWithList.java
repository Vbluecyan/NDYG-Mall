package com.bluecyan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @Author bluecyan
 * @DateTime 2021-04-20 1:16
 * @Description 将从数据库表clothing中取出的拼接字符串封装成 数组，列表 型数据
 **/

// 让jackson不把懒加载而又未加载的属性作为pojo封装
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ClothingWithList implements Serializable {

    private Clothing clothing;

    private String[] picture;

    private String[] size;

    public String[] getSize() {
        return size;
    }

    public Clothing getClothing() {
        return clothing;
    }

    public void setClothing(Clothing clothing) {
        this.clothing = clothing;
        picture = clothing.getPicture().split(",");
        size = clothing.getSize().split(",");
    }

    public String[] getPicture() {
        return picture;
    }
}
