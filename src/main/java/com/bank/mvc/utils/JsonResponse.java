package com.bank.mvc.utils;

import java.util.Map;

/**
 * Created by Zalman on 08.05.2015.
 */
public class JsonResponse {
    private String status = "";
    private Map<String, String> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public JsonResponse(String status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
    }
}
