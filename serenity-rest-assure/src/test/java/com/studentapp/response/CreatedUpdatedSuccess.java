package com.studentapp.response;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author trantrongnhan
 * Noted: This class could be considered to be deprecated when applying DTO for enhancement
 * <p>
 * Class implementation for Deserializing JSON response to Object for validation in Spec or reusing returned data
 */
public class CreatedUpdatedSuccess {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonCreator
    public CreatedUpdatedSuccess(String msg) {
        this.msg = msg;
    }
}
