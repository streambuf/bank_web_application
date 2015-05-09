package com.bank.mvc.utils;

import java.util.Map;

/**
 * Created by Zalman on 08.05.2015.
 */
public class JsonResponse {
    private String status = "";
    private Map<String, String> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public JsonResponse(String status, Map<String, String> data) {
        this.status = status;
        this.data = data;
    }
}
