package com.code.middleware.cashier.builder;

import com.code.middleware.cashier.ICashier;

/**
 * Created by hejiaxu on 2020/10/28
 */
public interface ICashierBuilder {
    ICashier init();
    ICashier buildHeader();
    ICashier buildFooter();
    ICashier buildBody();
}
