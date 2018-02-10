package de.cschulc.generator;

public interface RandomMarkDown {

    String getMarkdownFull();

    String getUeberschrift(int h);

    String getZitat();

    String getNummerierteListe(int anzahl);

    String getAufzaehlung(int anzahl);

    String getCodeBlock(int zeilen);




}
