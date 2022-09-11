package com.example.commonservice.model;

import lombok.Data;

/**
 * @author hpl
 */
@Data
public class Result<T> {
    private String data;

    private int code;

    private String message;

    private Throwable error;

}
