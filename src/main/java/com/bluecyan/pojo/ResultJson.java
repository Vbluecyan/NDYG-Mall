package com.bluecyan.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bluecyan
 * @DateTime 2021-04-18 1:06
 * @Description 通用json返回类
 **/
public class ResultJson {

    //状态码   100-成功    200-失败
    private int code;
    //提示信息
    private String msg;

    //服务器要返回给浏览器的数据
    private Map<String, Object> result = new HashMap<String, Object>();

    public static ResultJson success(){
        ResultJson result = new ResultJson();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }

    public static ResultJson fail(){
        ResultJson result = new ResultJson();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public ResultJson addObject(String key, Object value) {
        this.getResult().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
