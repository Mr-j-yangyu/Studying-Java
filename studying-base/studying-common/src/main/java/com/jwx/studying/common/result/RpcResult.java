package com.jwx.studying.common.result;

import com.sxc.gateway.client.GWResult;

import java.io.Serializable;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.common.result
 * FileName: RpcResult.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/22
 */
public class RpcResult<T extends Serializable> implements  Serializable {

    private static final long serialVersionUID = 2243608670743107943L;

    private T result;

    private int errorCode;

    private String subCode;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public boolean isSuccess() {
        return errorCode == 0;
    }

    public static <T extends Serializable> RpcResult<T> successResult(T t) {
        RpcResult<T> result = new RpcResult<T>();
        result.result = t;
        return result;
    }

    public static <T extends Serializable> RpcResult<T> errorResult(int code, String subCode) {
        RpcResult<T> result = new RpcResult<T>();
        result.errorCode = code;
        result.subCode = subCode;
        return result;
    }

    public static <T extends Serializable> RpcResult<T> errorResult(RpcResult<?> result) {
        if (result.isSuccess()) {
            return null;
        } else {
            return (RpcResult<T>) result;
        }
    }

    public static <T extends Serializable> RpcResult<T> errorResult(Throwable throwable) {
        RpcResult<T> result = new RpcResult<T>();
        result.errorCode = 10000;
        result.subCode = "ISP-unknow-" + throwable.getClass().getSimpleName();
        return result;
    }
}
