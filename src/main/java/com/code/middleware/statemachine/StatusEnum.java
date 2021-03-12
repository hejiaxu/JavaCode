package com.code.middleware.statemachine;

/**
 * Created by hejiaxu on 2020/10/28
 */
public enum  StatusEnum {
    NEW(0),
    CONFIRM(4),
    COMPLETE(6),
    SUCCESS(16),
    FAIL(14),
    CLOSED(13),
    ;
    Integer status;

    StatusEnum(Integer status) {
        this.status = status;
    }

    public static boolean isNew(StatusEnum statusEnum) {
        return NEW.equals(statusEnum);
    }
}
