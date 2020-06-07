package com.example.iot_manager.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class ResponseVO<T> implements Serializable {

    @ApiModelProperty("状态码 0失败，1成功")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    public ResponseVO(Integer code,String message ,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static <T> ResponseVO<T> buildSuccess(String message, T data) {
        return new ResponseVO<>(1,message ,data);
    }

    public static <T> ResponseVO<T> buildFailure(String message) {
        return new ResponseVO<>(0, message);
    }

    public static <T> ResponseVO<T> buildSuccess(T data) {
        return new ResponseVO<>(1, "success",data);
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }
}