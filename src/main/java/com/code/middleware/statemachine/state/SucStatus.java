package com.code.middleware.statemachine.state;

import com.code.middleware.statemachine.Order;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class SucStatus implements IState {

    @Override
    public void doSuccess(Order order) {
    }

    @Override
    public void doConfirm(Order order) {
    }

    @Override
    public void doClose(Order order) {
    }

    @Override
    public void doComplete(Order order) {
    }

    @Override
    public void doFail(Order order) {
    }
}
