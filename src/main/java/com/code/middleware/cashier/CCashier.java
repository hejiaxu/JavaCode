package com.code.middleware.cashier;

/**
 * Created by hejiaxu on 2020/10/28
 */
public class CCashier extends ICashier {
    String header;
    String footer;
    String body;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
