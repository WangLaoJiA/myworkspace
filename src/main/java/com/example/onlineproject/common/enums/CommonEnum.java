package com.example.onlineproject.common.enums;

import com.example.onlineproject.common.exception.BaseErrorInfoInterface;

public enum CommonEnum implements BaseErrorInfoInterface {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!"),
    SELF_HELP("-1", "不能给自己助力!"),
    NEED_SUBSCRIBE("-1", "提示订阅"),
    INDEX("/index", "提示首页"),
    LOGIN("/login", "提示登录"),
    REGISTER("/login", "提示注册"),
    RE_REGISTER("-1", "不可重复注册"),
    REPEAT("-1", "已为他人助力不可重复助力");


    /**
     * 错误码
     */
    private String resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
