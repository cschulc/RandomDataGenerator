package de.cschulc.generator;

public interface IRandomTextData {

    /**
     * Liefert eine Anzahl zufaelliger Woerter aus dem Katalog von Lorem Ipsum
     *
     * @param anzahl Die gewuenschte Anzahl Woerter
     * @return String
     */
    String getWoerter(int anzahl);

    /**
     * Liefert eine Anzahl zufaelliger Woerter aus dem Katalog von Lorem Ipsum
     *
     * @param min minimale Anzahl Woerter
     * @param max maximale Anzahl Woerter
     * @return String
     */
    String getWoerter(int min, int max);

    /**
     * Liefert einen zufaelligen Titel. Der erste Buchstabe ist groß.
     *
     * @param anzahl Anzahl der Woerter
     * @return String
     */
    String getTitel(int anzahl);

    /**
     * Liefert einen zufaelligen Titel. Der erste Buchstabe ist groß.
     *
     * @param min minimale Anzahl Woerter
     * @param max maximale Anzahl Woerter
     * @return
     */
    String getTitel(int min, int max);
}
