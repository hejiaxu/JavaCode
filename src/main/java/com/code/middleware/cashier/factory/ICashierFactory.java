package com.code.middleware.cashier.factory;

import com.code.middleware.cashier.ICashier;

/**
 * Created by hejiaxu on 2020/10/28
 */
public interface ICashierFactory {

    ICashier buildCashier();
}
