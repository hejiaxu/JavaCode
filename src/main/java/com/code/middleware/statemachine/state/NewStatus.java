package com.code.middleware.statemachine.state;

import com.code.middleware.statemachine.Order;
import com.code.middleware.statemachine.StatusEnum;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class NewStatus implements IState {

    @Override
    public void doSuccess(Order order) {
    }

    @Override
    public void doConfirm(Order order) {
        order.setStatus(StatusEnum.SUCCESS);
    }

    @Override
    public void doClose(Order order) {
        order.setStatus(StatusEnum.CLOSED);
    }

    @Override
    public void doComplete(Order order) {
    }

    @Override
    public void doFail(Order order) {
    }
}
