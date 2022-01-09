package com.baizhi.service;

public class BServiceImpl implements BService {
    @Override
    public void update() {
        System.out.println("BService Update");
    }

    @Override
    public String find() {
        System.out.println("BService Find");
        return "BService find";
    }
}
