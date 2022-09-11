package com.example.commonservice.util;

import com.example.commonservice.model.Result;

/**
 * @author hpl
 * @date 2022/9/11 17:02
 */
public class ResultUtil {
    public static <T> Result<T> buildResult(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> buildFailResult() {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        return result;
    }

    public static <T> Result<T> buildResult(T data, int code, String message, Throwable t) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setData(data);
        result.setError(t);
        result.setSuccess(true);
        result.setMessage(message);

        return result;
    }
}
