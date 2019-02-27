/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc;

import com.github.cschulc.core.RandomMarkdownImpl;
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
