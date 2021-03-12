package com.code.middleware.statemachine.strategy;

import com.code.middleware.statemachine.Order;
import com.code.middleware.statemachine.StatusEnum;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class New2ConfirmStrategy implements IStrategy {
    @Override
    public void process(Order order) {
        if (StatusEnum.isNew(order.getStatus())) {
            order.setStatus(StatusEnum.CONFIRM);
        }
    }
}
