package com.code.middleware.cashier.template;

import com.code.middleware.cashier.ICashier;

/**
 * Created by hejiaxu on 2020/10/28
 */
public abstract class AbstractCashier {

    abstract void buildHeader(ICashier cashier);
    abstract void buildFooter(ICashier cashier);
    abstract void buildBody(ICashier cashier);

    public ICashier buildCashier(ICashier cashier) {
        buildHeader(cashier);
        buildFooter(cashier);
        buildBody(cashier);
        return cashier;
    }
}
