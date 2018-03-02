package com.github.cschulc.domain;

public class RandomStadt {

    private final String plz;

    private final String name;

    public RandomStadt(String plz, String name) {
        this.plz = plz;
        this.name = name;
    }

    public String getPlz() {
        return plz;
    }

    public String getName() {
        return name;
    }
}
