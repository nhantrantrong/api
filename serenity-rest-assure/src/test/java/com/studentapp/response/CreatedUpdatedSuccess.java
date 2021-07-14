package com.studentapp.response;

import com.fasterxml.jackson.annotation.JsonCreator;

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
