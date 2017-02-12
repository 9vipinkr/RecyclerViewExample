package com.vipinkr.recyclerviewexample;

/**
 * Created by Vipin K R on 24-01-2017.
 */

public class Person {

    private String name;
    private int thumbnail;

    public Person(String name, int thumbnail) {
        setName(name);
        setThumbnail(thumbnail);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }



}
