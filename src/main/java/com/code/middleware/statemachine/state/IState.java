package com.code.middleware.statemachine.state;

import com.code.middleware.statemachine.Order;

/**
 * Created by hejiaxu on 2020/10/28
 */
public interface IState {
    void doSuccess(Order order);
    void doConfirm(Order order);
    void doClose(Order order);
    void doComplete(Order order);
    void doFail(Order order);
}
