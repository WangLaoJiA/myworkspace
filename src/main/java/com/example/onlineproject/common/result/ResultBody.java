package com.example.onlineproject.common.result;

import com.alibaba.fastjson.JSONObject;
import com.example.onlineproject.common.enums.CommonEnum;
import com.example.onlineproject.common.exception.BaseErrorInfoInterface;


public class ResultBody {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBody() {
    }

    public ResultBody(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 登录
     *
     * @return
     */
    public static ResultBody login(String msg) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.LOGIN.getResultCode());
        rb.setMessage(CommonEnum.LOGIN.getResultMsg());
        rb.setResult(msg);
        return rb;
    }

    /**
     * 首页
     *
     * @return
     */
    public static ResultBody index() {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.INDEX.getResultCode());
        rb.setMessage(CommonEnum.INDEX.getResultMsg());
        rb.setResult("首页");
        return rb;
    }

    /**
     * 注册
     *
     * @returnAlready
     */
    public static ResultBody register(String msg) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.REGISTER.getResultCode());
        rb.setMessage(CommonEnum.REGISTER.getResultMsg());
        rb.setResult(msg);
        return rb;
    }

    /**
     * 注册
     *
     * @return
     */
    public static ResultBody alreadyRegister(String msg,String data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.RE_REGISTER.getResultCode());
        rb.setMessage(msg);
        rb.setResult(data);
        return rb;
    }

    public static Boolean isSuccess(String code) {
        if (code.equals(CommonEnum.SUCCESS.getResultCode())){
            return true;
        }
        return false;
    }

    public static ResultBody repeat() {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.REPEAT.getResultCode());
        rb.setMessage(CommonEnum.REPEAT.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    public static ResultBody selfHelp() {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SELF_HELP.getResultCode());
        rb.setMessage(CommonEnum.SELF_HELP.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody needSubscribe(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(CommonEnum.NEED_SUBSCRIBE.getResultCode());
        rb.setMessage(CommonEnum.NEED_SUBSCRIBE.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseErrorInfoInterface errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    public static ResultBody error(BaseErrorInfoInterface errorInfo,String result) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(result);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
