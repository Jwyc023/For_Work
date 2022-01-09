package com.baizhi.vo;

import java.util.List;
import java.util.Map;

//自定义Vo对象
public class CollectionVO {

    private List<String> lists;

    private Map<String,String> maps;

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}
