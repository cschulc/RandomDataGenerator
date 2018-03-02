package com.github.cschulc.core;

import com.github.cschulc.RandomMarkDown;
import com.github.cschulc.RandomText;

public class RandomMarkdownImpl extends RandomBase implements RandomMarkDown {


    RandomText randomText = new RandomTextmpl();
    public static final String ZEILENUMBRUCH = "\n";
    private static final String ZEILEUMBRUCH_DOPPELT = "\n\n";

    @Override
    public String getMarkdownFull() {
        StringBuilder sb = new StringBuilder();
        sb.append(getUeberschrift(1)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(randomText.getAbsatz(5)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getUeberschrift(2)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getNummerierteListe(5)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getHorizontaleLinie()).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getAufzaehlung(4)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getUeberschrift(3)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getLink()).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getUeberschrift(3)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getCodeBlock(6)).append(ZEILEUMBRUCH_DOPPELT);
        sb.append(getAbsatz()).append(ZEILEUMBRUCH_DOPPELT);
        return sb.toString();
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
            sb.append(">").append(randomText.getWoerter(10)).append(ZEILENUMBRUCH);
        }
        return sb.toString();
    }

    @Override
    public String getNummerierteListe(int anzahl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anzahl; i++) {
            sb.append(i+1).append(". ").append(randomText.getWoerter(1)).append(ZEILENUMBRUCH);
        }
        return sb.toString();
    }

    @Override
    public String getAufzaehlung(int anzahl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < anzahl; i++) {
            sb.append("* ").append(randomText.getWoerter(1)).append(ZEILENUMBRUCH);
        }
        return sb.toString();
    }

    @Override
    public String getCodeBlock(int zeilen) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeilen; i++) {
            int n = random.nextInt(9);
            sb.append("\t").append(randomText.getWoerter(n)).append(ZEILENUMBRUCH);
        }
        return sb.toString();
    }

    @Override
    public String getHorizontaleLinie() {
        return "*****\n";
    }

    @Override
    public String getLink() {
        String titel = randomText.getTitel(2);
        String url = "http://example.com";
        return getLink(titel, url);
    }

    @Override
    public String getLink(String title, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(title).append("]").append("(").append(url).append(")");
        return sb.toString();
    }

    @Override
    public String getStrongText() {
        StringBuilder sb = new StringBuilder();
        int nextInt = random.nextInt(5);
        String woerter = randomText.getWoerter(nextInt);
        return sb.append("*").append(woerter).append("*").toString();
    }

    @Override
    public String getKursivText() {
        StringBuilder sb = new StringBuilder();
        int nextInt = random.nextInt(5);
        String woerter = randomText.getWoerter(nextInt);
        return sb.append("**").append(woerter).append("**").toString();
    }

    @Override
    public String getCodeBereich() {
        StringBuilder sb = new StringBuilder();
        return sb.append(" `").append("printf()").append("` ").toString();
    }

    @Override
    public String getAbsatz() {
        StringBuilder sb = new StringBuilder();
        sb.append(randomText.getWoerter(3)).append(getKursivText()).append(randomText.getWoerter(4)).append(ZEILENUMBRUCH);
        sb.append(randomText.getWoerter(5)).append(getCodeBereich()).append(randomText.getWoerter(3)).append(ZEILENUMBRUCH);
        sb.append(randomText.getWoerter(4)).append(getStrongText()).append(randomText.getWoerter(4)).append(ZEILENUMBRUCH);
        return sb.toString();
    }
}
