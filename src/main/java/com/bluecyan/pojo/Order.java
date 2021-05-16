package com.bluecyan.pojo;

import java.util.Date;

//用户租衣订单
public class Order {
    private String orderId;

    private String userId;

    private String clothingId;

    private Integer money;

    private Date creationDatetime;

    private Date finishDatetime;

    private Date expectantReturnDate;

    private Date actualReturnDate;

    private String commentPicture;

    private String commentText;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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

    public String getCommentPicture() {
        return commentPicture;
    }

    public void setCommentPicture(String commentPicture) {
        this.commentPicture = commentPicture == null ? null : commentPicture.trim();
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "orderId='" + orderId + '\'' +
//                ", userId='" + userId + '\'' +
//                ", clothingId='" + clothingId + '\'' +
//                ", money=" + money +
//                ", creationDatetime=" + creationDatetime +
//                ", finishDatetime=" + finishDatetime +
//                ", expectantReturnDate=" + expectantReturnDate +
//                ", actualReturnDate=" + actualReturnDate +
//                ", commentPicture='" + commentPicture + '\'' +
//                ", commentText='" + commentText + '\'' +
//                '}';
//    }
}