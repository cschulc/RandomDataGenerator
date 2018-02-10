package de.cschulc.generator;

import de.cschulc.generator.domain.RandomStadt;
import org.junit.Assert;
import org.junit.Test;

public class TestRandomDataImpl {

    @Test
    public void testRandomData(){
        RandomData randomData = new RandomDataImpl();
        Assert.assertNotNull(randomData);
        RandomStadt stadt = randomData.getStadt();
        Assert.assertNotNull(stadt);
    }
}
