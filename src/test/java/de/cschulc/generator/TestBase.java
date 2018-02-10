package de.cschulc.generator;

import org.junit.Before;

import java.util.Random;

public abstract class TestBase {

    protected Random random;

    @Before
    public void beforeTest(){
        random = new Random();
    }
}
