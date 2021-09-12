package com.liu.service;

import java.util.List;

public class Cube {
    public Cube() {
    }

    public Cube(String name, List<String> columns) {
        this.name = name;
        this.columns = columns;
    }

    private String name;
    private List<String> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                '}';
    }
}
