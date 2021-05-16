package com.bluecyan.pojo;

//管理员账号
public class Admin {
    private String adminId;

    private String password;

    private String messageList;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMessageList() {
        return messageList;
    }

    public void setMessageList(String messageList) {
        this.messageList = messageList == null ? null : messageList.trim();
    }
}