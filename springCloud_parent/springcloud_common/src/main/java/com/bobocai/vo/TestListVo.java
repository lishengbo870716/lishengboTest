package com.bobocai.vo;

import java.util.List;

/**
 * 测试传递list对象是否可以使用
 */
public class TestListVo {


    List<String> list;
    String name;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestListVo{" +
                "list=" + list +
                ", name='" + name + '\'' +
                '}';
    }
}
