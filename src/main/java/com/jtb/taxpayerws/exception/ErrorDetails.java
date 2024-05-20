package com.jtb.taxpayerws.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

public class ErrorDetails {
    private int status;
    private String message;
    private String info;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final Map<String, Object> errors = new HashMap<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void addErrors(String field, String message) {
        errors.put(field, message);
    }
}
