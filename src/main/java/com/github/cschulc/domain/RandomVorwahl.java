package com.github.cschulc.domain;

public class RandomVorwahl {

    public final String vorwahl;

    public final String stadt;

    public RandomVorwahl(String vorwahl, String stadt) {
        this.vorwahl = vorwahl;
        this.stadt = stadt;
    }

    public String getVorwahl() {
        return vorwahl;
    }

    public String getStadt() {
        return stadt;
    }
}
