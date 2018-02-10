package de.cschulc.generator.core;

import de.cschulc.generator.RandomMarkDown;
import de.cschulc.generator.RandomText;

public class RandomMarkdownImpl extends RandomBase implements RandomMarkDown {

    RandomText randomText = new RandomTextmpl();

    @Override
    public String getMarkdownFull() {
        return null;
    }

    @Override
    public String getUeberschrift(int h) {
        if(h < 1 || h > 6){
            System.err.println("Invalid Argument, h must be between 1 and 6");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            sb.append("#");
        }
        sb.append(" ").append(randomText.getTitel(h));
        return sb.toString();
    }

    @Override
    public String getZitat() {
        StringBuilder sb = new StringBuilder();
        int zeilen = random.nextInt(5);
        for (int i = 0; i < zeilen; i++) {
            sb.append(">").append(randomText.getWoerter(10)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getNummerierteListe(int anzahl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anzahl; i++) {
            sb.append(i+1).append(". ").append(randomText.getWoerter(1)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getAufzaehlung(int anzahl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anzahl; i++) {
            sb.append("* ").append(randomText.getWoerter(1)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getCodeBlock(int zeilen) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeilen; i++) {
            int n = random.nextInt(9);
            sb.append("\t").append(randomText.getWoerter(n)).append("\n");
        }
        return sb.toString();
    }
}
