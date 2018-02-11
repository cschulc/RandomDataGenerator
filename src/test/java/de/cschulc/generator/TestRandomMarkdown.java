package de.cschulc.generator;

import de.cschulc.generator.core.RandomMarkdownImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestRandomMarkdown extends TestBase {

    RandomMarkDown randomMarkDown = new RandomMarkdownImpl();

    @Test
    public void testGetMarkdownFull(){
        String markdownFull = randomMarkDown.getMarkdownFull();
        Assert.assertNotNull(markdownFull);
    }

    @Test
    public void testGetZitat() {
        String zitat = randomMarkDown.getZitat();
        Assert.assertNotNull(zitat);
        Assert.assertFalse(zitat.isEmpty());
    }

    @Test
    public void testGetUeberschrift() {
        for (int h = 1; h < 7; h++) {
            String ueberschrift = randomMarkDown.getUeberschrift(h);
            char[] chars = ueberschrift.toCharArray();
            for (int i = 0; i < h; i++) {
                String s = String.valueOf(chars[i]);
                Assert.assertTrue(s.equals("#"));
            }
            char aChar = chars[h];
            String space = String.valueOf(aChar);
            Assert.assertTrue(space.equals(" "));
        }
    }

    @Test
    public void testGetNummerierteListe() {
        int anzahl = random.nextInt(15);
        String nummerierteListe = randomMarkDown.getNummerierteListe(anzahl);
        for (int i = 1; i <= anzahl; i++) {
            Assert.assertTrue(nummerierteListe.contains(i + ". "));
        }
    }

    @Test
    public void testGetCodeBlock(){
        int zeilen = random.nextInt(20);
        String codeBlock = randomMarkDown.getCodeBlock(zeilen);
        Assert.assertTrue(codeBlock.startsWith("\t"));
        String[] split = codeBlock.split("\t");
        Assert.assertEquals(zeilen+1, split.length);
    }

}
