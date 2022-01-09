package com.baizhi.service;

public class AServiceImpl implements AService {


    private BService bbbbService;

    public void setBbbbService(BService bbbbService) {
        this.bbbbService = bbbbService;
    }

    @Override
    public void save() {//开启事务
        bbbbService.update();
        System.out.println("AService Save");
    }

    @Override
    public String find() {
        System.out.println("AService Find");
        return "AService find";
    }
}
