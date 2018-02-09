package de.cschulc.generator;

import de.cschulc.generator.domain.RandomStadt;
import org.junit.Assert;
import org.junit.Test;

public class TestRandomData {

    @Test
    public void testRandomData(){
        RandomData randomData = RandomData.getInstance();
        Assert.assertNotNull(randomData);
        RandomStadt stadt = randomData.getStadt();
        Assert.assertNotNull(stadt);
    }
}
