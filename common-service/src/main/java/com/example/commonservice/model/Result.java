package com.example.commonservice.model;

import lombok.Data;

/**
 * @author hpl
 */
@Data
public class Result<T> {

    private T data;

    private Boolean success;

    private int code;

    private String message;

    private Throwable error;

}
