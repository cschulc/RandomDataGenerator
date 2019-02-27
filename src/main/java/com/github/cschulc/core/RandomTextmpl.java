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

package com.github.cschulc.core;

import com.github.cschulc.RandomText;

public class RandomTextmpl extends RandomBase implements RandomText {

    @Override
    public String getWoerter(int anzahl) {
        return getWords(anzahl);
    }

    @Override
    public String getWoerter(int min, int max) {
        int count = getCount(min, max);
        return getWords(count);
    }

    @Override
    public String getTitel(int anzahl) {
        String words = getWords(anzahl);
        return toTitle(words);
    }

    @Override
    public String getTitel(int min, int max) {
        String woerter = getWoerter(min, max);
        return toTitle(woerter);
    }

    @Override
    public String getTitelMitLaenge(int minZeichen, int maxZeichen) {
        int count = getCount(minZeichen, maxZeichen);
        String wortMitLaenge = getWortMitLaenge(count);
        return toTitle(wortMitLaenge);
    }


    @Override
    public String getAbsatz(int zeilen) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeilen; i++) {
            sb.append(getWoerter(10)).append("\n");
        }
        return sb.toString();
    }

    private String getWords(int anzahl) {
        StringBuilder sb = new StringBuilder();
        int size = dataHolder.woerter.size();
        int count = 0;
        while (count < anzahl) {
            String word = dataHolder.woerter.get(random.nextInt(size));
            sb.append(word).append(" ");
            count++;
        }
        return sb.toString().trim();
    }

    private String getWortMitLaenge(int laenge){
        String retval = null;
        int size = dataHolder.woerter.size();
        while (retval == null) {
            String wort = dataHolder.woerter.get(random.nextInt(size));
            if(wort.length() == laenge){
                retval = wort;
            }
        }
        return retval;
    }


    /**
     * Wandelt den ersten Buchstaben in der Woerter in Groß um.
     *
     * @param words Der String der Wöerter
     * @return String
     */
    private String toTitle(String words) {
        return words.substring(0, 1).toUpperCase() + words.substring(1);
    }


}
