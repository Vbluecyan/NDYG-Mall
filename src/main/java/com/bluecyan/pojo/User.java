package com.bluecyan.pojo;

public class User {
    private String userId;

    private String password;

    private String nickname;

    private String sex;

    private String profilePhoto;

    private Byte member;

    private String shippingAddress;

    private String favorites;

    private String suitcase;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto == null ? null : profilePhoto.trim();
    }

    public Byte getMember() {
        return member;
    }

    public void setMember(Byte member) {
        this.member = member;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress == null ? null : shippingAddress.trim();
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites == null ? null : favorites.trim();
    }

    public String getSuitcase() {
        return suitcase;
    }

    public void setSuitcase(String suitcase) {
        this.suitcase = suitcase == null ? null : suitcase.trim();
    }
}