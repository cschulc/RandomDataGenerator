package com.github.cschulc;

import com.github.cschulc.core.RandomDataImpl;
import com.github.cschulc.domain.RandomStadt;
import org.junit.Assert;
import org.junit.Test;

public class TestRandomData {

    @Test
    public void testRandomData(){
        RandomData randomData = new RandomDataImpl();
        Assert.assertNotNull(randomData);
        RandomStadt stadt = randomData.getStadt();
        Assert.assertNotNull(stadt);
    }
}
