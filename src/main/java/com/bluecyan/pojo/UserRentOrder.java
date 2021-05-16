package com.bluecyan.pojo;

import java.util.Date;

//用户出租服装订单
public class UserRentOrder {
    private String userRentOrderId;

    private String userId;

    private String clothingId;

    private String shippingAddress;

    private Integer money;

    private Date creationDatetime;

    private Date finishDatetime;

    private Date expectantReturnDate;

    private Date actualReturnDate;

    private Byte pass;

    public String getUserRentOrderId() {
        return userRentOrderId;
    }

    public void setUserRentOrderId(String userRentOrderId) {
        this.userRentOrderId = userRentOrderId == null ? null : userRentOrderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getClothingId() {
        return clothingId;
    }

    public void setClothingId(String clothingId) {
        this.clothingId = clothingId == null ? null : clothingId.trim();
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getFinishDatetime() {
        return finishDatetime;
    }

    public void setFinishDatetime(Date finishDatetime) {
        this.finishDatetime = finishDatetime;
    }

    public Date getExpectantReturnDate() {
        return expectantReturnDate;
    }

    public void setExpectantReturnDate(Date expectantReturnDate) {
        this.expectantReturnDate = expectantReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Byte getPass() {
        return pass;
    }

    public void setPass(Byte pass) {
        this.pass = pass;
    }
}