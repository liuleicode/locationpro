package com.ll.location.domain;

/**
 * Created by liulei on 2017/7/17.
 */
public class ExecuteResult {
    //0-成功 1-失败
    String success;
    String message;

    public ExecuteResult() {
    }

    public ExecuteResult(String success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
