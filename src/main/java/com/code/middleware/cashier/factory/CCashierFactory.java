package com.code.middleware.cashier.factory;

import com.code.middleware.cashier.CCashier;
import com.code.middleware.cashier.ICashier;

/**
 * Created by hejiaxu on 2020/10/29
 */
public class CCashierFactory implements ICashierFactory {
    @Override
    public ICashier buildCashier() {
        return new CCashier();
    }
}
