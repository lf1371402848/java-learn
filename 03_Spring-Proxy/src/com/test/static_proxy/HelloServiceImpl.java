package com.test.static_proxy;

import java.util.Date;

public class HelloServiceImpl implements HelloService{

    @Override
    public Date getTime() {
        return new Date();
    }
}