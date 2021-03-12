package com.code.middleware.cashier.builder;

import com.code.middleware.cashier.CCashier;
import com.code.middleware.cashier.ICashier;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class CCashierBuilder implements ICashierBuilder {
    CCashier cashier;

    @Override
    public ICashier init() {
        cashier = new CCashier();
        return cashier;
    }

    @Override
    public ICashier buildHeader() {
        cashier.setHeader("cHeader");
        return cashier;
    }

    @Override
    public ICashier buildFooter() {
        cashier.setFooter("cFooter");
        return cashier;

    }

    @Override
    public ICashier buildBody() {
        cashier.setBody("cBody");
        return cashier;
    }

    public ICashier buildCashier() {
        buildBody();
        buildFooter();
        buildHeader();
        return cashier;
    }

}
