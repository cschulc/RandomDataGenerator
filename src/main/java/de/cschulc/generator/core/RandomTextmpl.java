package de.cschulc.generator.core;

import de.cschulc.generator.RandomText;

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
