package com.bank.mvc.utils;

/**
 * Created by Zalman on 23.05.2015.
 */
public class JsonRequest {

    private String stringParam;
    private Long longParam;

    public JsonRequest() {
    }

    public String getStringParam() {
        return stringParam;
    }

    public void setStringParam(String stringParam) {
        this.stringParam = stringParam;
    }

    public Long getLongParam() {
        return longParam;
    }

    public void setLongParam(Long longParam) {
        this.longParam = longParam;
    }
}
