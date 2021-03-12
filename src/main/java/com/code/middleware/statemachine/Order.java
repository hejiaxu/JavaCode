package com.code.middleware.statemachine;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class Order {
    StatusEnum status;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
