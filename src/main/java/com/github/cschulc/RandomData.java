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

import com.github.cschulc.domain.RandomAdresse;
import com.github.cschulc.domain.RandomStadt;
import com.github.cschulc.domain.RandomPerson;

public interface RandomData {

    /**
     * Liefert einen zufaellige Person mit Adresse
     *
     * @return RandomPerson
     */
    RandomPerson getPerson();

    /**
     * Liefert einen zufaellige maennliche Person mit Adresse
     *
     * @return RandomPerson
     */
    RandomPerson getPersonMaennlich();

    /**
     * Liefert einen zufaellige weibliche Person mit Adresse
     *
     * @return RandomPerson
     */
    RandomPerson getPersonWeiblich();

    /**
     * Liefert eine zufaellige Adresse
     *
     * @return RandomAdresse
     */
    RandomAdresse getAdresse();

    /**
     * Liefert eine zufaellige Stadt mit Postleitzahl
     *
     * @return RandomStadt
     */
    RandomStadt getStadt();

    /**
     * Liefert ein zufaelligen Land
     *
     * @return String
     */
    String getLand();

    /**
     * Liefert einen Benutzername in der Form ERSTER_BUCHSTABE_VORNAME.NACHNAME
     *
     * @return String
     */
    String getUsername();

    /**
     * Liefert einen Benutzername in der Form ERSTER_BUCHSTABE_VORNAME.NACHNAME
     *
     * @param vorname Der Vorname
     * @param nachname Der Nachname
     * @return String
     */
    String getUsername(String vorname, String nachname);

    /**
     * Liefert einen zufaelligen Vorname, maennlich oder weiblich
     *
     * @return String
     */
    String getVorname();

    /**
     * Liefert einen zufaelligen maenlichen Vornamen
     *
     * @return String
     */
    String getVornameMaennlich();

    /**
     * Liefert einen zufaelligen weiblichen Vornamen
     *
     * @return String
     */
    String getVornameWeiblich();

    /**
     * Liefert einen Nachnamen
     *
     * @return String
     */
    String getNachname();

    /**
     * Liefert eine zufaellige Festnetznummer
     *
     * @return String
     */
    String getTelefonnummer();

    /**
     * Liefert eine zufaellige Festnetznummer mit dem gewuenschten Trennzwichen
     *
     * @param trennzeichen Das gewuenschte Trennzeichen
     * @return String
     */
    String getTelefonnummer(String trennzeichen);

    /**
     * Liefert eine zufaellige Handynummer
     *
     * @return String
     */
    String getHandynummer();

    /**
     * Liefert eine zufaellige Handynummer mit dem gewuenschten Trennzwichen
     *
     * @param trennzeichen Das gewuenschte Trennzeichen
     * @return String
     */
    String getHandynummer(String trennzeichen);

    /**
     * Liefert einen zufaellige Email-Adresse aus Vorname.Nachmache@test.de
     *
     * @return String
     */
    String getEmail();

    /**
     * Liefert einen zufaellige Email-Adresse aus Vorname.Nachname@domain
     *
     * @param domain Die domain der Email-Adressen
     * @return String
     */
    String getEmail(String domain);

    /**
     * Liefert einen zufaellige maennliche Email-Adresse aus Vorname.Nachmachen@test.de
     *
     * @return String
     */
    String getEmailMaennlich();

    /**
     * Liefert einen zufaellige maennliche Email-Adresse aus Vorname.Nachname@domain
     *
     * @param domain Die domain der Email-Adressen
     * @return String
     */
    String getEmailMaennlich(String domain);

    /**
     * Liefert einen zufaellige weibliche Email-Adresse aus Vorname.Nachmachen@test.de
     *
     * @return String
     */
    String getEmailWeiblich();

    /**
     * Liefert einen zufaellige weibliche Email-Adresse aus Vorname.Nachname@domain
     *
     * @param domain Die domain der Email-Adressen
     * @return String
     */
    String getEmailWeiblich(String domain);

    /**
     * Baut aus den uebergebenen Werten die Email-Adresse vorname.nachname@domain
     *
     * @param vorname  Ein Vorname
     * @param nachname Ein Nachname
     * @param domain   Eine Domain
     * @return String
     */
    String getEmail(String vorname, String nachname, String domain);

    /**
     * Baut aus den uebergebenen Werten die Email-Adresse vorname.nachname@test.de
     *
     * @param vorname  Ein Vorname
     * @param nachname Ein Nachname
     * @return String
     */
    String getEmail(String vorname, String nachname);

    /**
     * Liefert einen zufaelligen Strassennamen
     *
     * @return String
     */
    String getStrasse();

    /**
     * Liefert eine zufaellige Hausnummer bis 250
     *
     * @return String
     */
    String getHausnummer();

    /**
     * Liefert einen zufaellige Strasse mit Hausnummer
     *
     * @return String
     */
    String getStrasseMitHausnummer();


}
