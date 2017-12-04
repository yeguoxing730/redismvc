package com.springapp.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book implements Serializable{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
