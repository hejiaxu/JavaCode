package com.code.middleware.statemachine.strategy;

import com.code.middleware.statemachine.Order;

/**
 * Created by hejiaxu on 2020/10/28
 */
public interface IStrategy {
    void process(Order order);
}
