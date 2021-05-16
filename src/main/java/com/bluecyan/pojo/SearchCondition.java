package com.bluecyan.pojo;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 21:41
 * @Description 搜索条件
 **/
public class SearchCondition {

    private String keyword;
    private int[] brands;
    private int[] categorys;
    private int[] styles;
    private String sizes;
    private String order;
    private String[] sexs;
    private int pageNum;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int[] getBrands() {
        return brands;
    }

    public void setBrands(int[] brands) {
        this.brands = brands;
    }

    public int[] getCategorys() {
        return categorys;
    }

    public void setCategorys(int[] categorys) {
        this.categorys = categorys;
    }

    public int[] getStyles() {
        return styles;
    }

    public void setStyles(int[] styles) {
        this.styles = styles;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String[] getSexs() {
        return sexs;
    }

    public void setSexs(String[] sexs) {
        this.sexs = sexs;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
