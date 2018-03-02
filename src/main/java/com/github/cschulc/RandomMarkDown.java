package com.github.cschulc;

public interface RandomMarkDown {

    String getMarkdownFull();

    String getUeberschrift(int h);

    String getZitat();

    String getNummerierteListe(int anzahl);

    String getAufzaehlung(int anzahl);

    String getCodeBlock(int zeilen);

    String getHorizontaleLinie();

    String getLink();

    String getLink(String title, String url);

    String getStrongText();

    String getKursivText();

    String getCodeBereich();

    String getAbsatz();


}
