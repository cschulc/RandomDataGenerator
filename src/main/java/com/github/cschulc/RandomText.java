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

public interface RandomText {

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
     * @return String
     */
    String getTitel(int min, int max);

    /**
     * Liefert einen Title mit mindest und maximal zeichen
     *
     * @param minZeichen Das minimum an Zeichen
     * @param maxZeichen Das maximum an Zeichen
     * @return String
     */
    String getTitelMitLaenge(int minZeichen, int maxZeichen);

    /**
     * Liefert einen Absatz mit der gewuenschten Anzahl an Zeilen.
     *
     * @param zeilen Die gewuenschte Anzahl an Zeilen
     * @return String
     */
    String getAbsatz(int zeilen);
}
