package com.baizhi.entity;

public class Emp {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp() {
    }

    public Emp(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
