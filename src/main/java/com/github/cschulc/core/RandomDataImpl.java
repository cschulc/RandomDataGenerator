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

import com.github.cschulc.domain.RandomAdresse;
import com.github.cschulc.domain.RandomStadt;
import com.github.cschulc.domain.RandomVorwahl;
import com.github.cschulc.RandomData;
import com.github.cschulc.domain.RandomPerson;

public class RandomDataImpl extends RandomBase implements RandomData {

    @Override
    public RandomPerson getPerson() {
        String vorname = getVorname();
        return getPerson(vorname);
    }

    @Override
    public RandomPerson getPersonMaennlich() {
        String vorname = getVornameMaennlich();
        return getPerson(vorname);
    }

    @Override
    public RandomPerson getPersonWeiblich() {
        String vorname = getVornameWeiblich();
        return getPerson(vorname);
    }

    @Override
    public RandomAdresse getAdresse() {
        String strasse = getStrasse();
        String hausnummer = getHausnummer();
        RandomStadt stadt = getStadt();
        return new RandomAdresse(strasse, hausnummer, stadt.getPlz(), stadt.getName());
    }

    @Override
    public RandomStadt getStadt() {
        int size = dataHolder.staedte.size();
        return dataHolder.staedte.get(random.nextInt(size));
    }

    @Override
    public String getLand() {
        return getRandomElement(dataHolder.laender);
    }

    @Override
    public String getUsername() {
        String vorname = getVorname();
        String nachname = getNachname();
        return createUsername(vorname, nachname);
    }

    @Override
    public String getUsername(String vorname, String nachname) {
        return createUsername(vorname, nachname);
    }

    @Override
    public String getVorname() {
        return getRandomElement(dataHolder.vornamen);
    }

    @Override
    public String getVornameMaennlich() {
        return getRandomElement(dataHolder.vorname_m);
    }

    @Override
    public String getVornameWeiblich() {
        return getRandomElement(dataHolder.vorname_w);
    }

    @Override
    public String getNachname() {
        return getRandomElement(dataHolder.nachnamen);
    }


    @Override
    public String getTelefonnummer() {
        String randomNumber = getRandomNumber(4, 8);
        int size = dataHolder.vorwahl_stadt.size();
        RandomVorwahl randomVorwahl = dataHolder.vorwahl_stadt.get(random.nextInt(size));
        return randomVorwahl.getVorwahl() + randomNumber;
    }

    @Override
    public String getTelefonnummer(String trennzeichen) {
        String randomNumber = getRandomNumber(4, 8);
        int size = dataHolder.vorwahl_stadt.size();
        RandomVorwahl randomVorwahl = dataHolder.vorwahl_stadt.get(random.nextInt(size));
        return randomVorwahl.getVorwahl() + trennzeichen + randomNumber;
    }

    @Override
    public String getHandynummer() {
        String randomNumber = getRandomNumber(7, 10);
        return getRandomElement(dataHolder.handyvorwahl_de) + randomNumber;
    }

    @Override
    public String getHandynummer(String trennzeichen) {
        String randomNumber = getRandomNumber(7, 10);
        return getRandomElement(dataHolder.handyvorwahl_de) + trennzeichen + randomNumber;
    }

    @Override
    public String getEmail() {
        String vorname = getRandomElement(dataHolder.vornamen);
        String nachname = getRandomElement(dataHolder.nachnamen);
        String domain = getRandomElement(dataHolder.domains);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmail(String domain) {
        String vorname = getRandomElement(dataHolder.vornamen);
        String nachname = getRandomElement(dataHolder.nachnamen);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmailMaennlich() {
        String vorname = getRandomElement(dataHolder.vorname_m);
        String nachname = getRandomElement(dataHolder.nachnamen);
        String domain = getRandomElement(dataHolder.domains);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmailMaennlich(String domain) {
        String vorname = getRandomElement(dataHolder.vorname_m);
        String nachname = getRandomElement(dataHolder.nachnamen);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmailWeiblich() {
        String vorname = getRandomElement(dataHolder.vorname_w);
        String nachname = getRandomElement(dataHolder.nachnamen);
        String domain = getRandomElement(dataHolder.domains);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmailWeiblich(String domain) {
        String vorname = getRandomElement(dataHolder.vorname_w);
        String nachname = getRandomElement(dataHolder.nachnamen);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmail(String vorname, String nachname, String domain) {
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getEmail(String vorname, String nachname) {
        String domain = getRandomElement(dataHolder.domains);
        return buildEmailAddress(vorname, nachname, domain);
    }

    @Override
    public String getStrasse() {
        StringBuilder sb = new StringBuilder();
        int count = getCount(0, 4);
        switch (count) {
            case 0:
                sb.append(getRandomElement(dataHolder.vornamen));
                break;
            case 1:
                sb.append(getRandomElement(dataHolder.nachnamen));
                break;
            case 2:
                sb.append(getRandomElement(dataHolder.laender));
                break;
            case 3:
                sb.append(getRandomElement(dataHolder.woerter));
                break;
            case 4:
                RandomStadt stadt = getStadt();
                sb.append(stadt.getName());
                break;
        }
        String endung = getRandomElement(dataHolder.strassenendung);
        sb.append(endung);
        return sb.toString();
    }

    @Override
    public String getHausnummer() {
        return String.valueOf(random.nextInt(250));
    }

    @Override
    public String getStrasseMitHausnummer() {
        return getStrasse() + " " + getHausnummer();
    }


    private String getRandomNumber(int min, int max) {
        StringBuilder sb = new StringBuilder();
        // Damit die Telefonnummer nicht mit 0 beginnt
        sb.append(random.nextInt(9) + 1);
        // laenge der Telefonnummer
        int lenght = getCount(min, max);
        for (int i = 0; i < lenght; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    private String buildEmailAddress(String vorname, String nachname, String domain) {
        StringBuilder sb = new StringBuilder();
        String email = sb.append(vorname).append(".").append(nachname).append("@").append(domain).toString();
        return replaceUmlaut(email);
    }

    private RandomPerson getPerson(String vorname) {
        String nachname = getNachname();
        RandomAdresse adresse = getAdresse();
        String telefonnummer = getTelefonnummer();
        String handynummer = getHandynummer();
        return new RandomPerson(adresse, vorname, nachname, telefonnummer, handynummer);
    }

    private String createUsername(String vorname, String nachname) {
        if (vorname == null || nachname == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String substring = vorname.substring(0, 1);
        sb.append(substring).append(".").append(nachname);
        return sb.toString().toLowerCase();
    }

    private String replaceUmlaut(String input) {

        //replace all lower Umlauts
        String output = input.replace("ü", "ue")
                .replace("ö", "oe")
                .replace("ä", "ae")
                .replace("ß", "ss");

        //first replace all capital umlaute in a non-capitalized context (e.g. Übung)
        output = output.replace("Ü(?=[a-zäöüß ])", "Ue")
                .replace("Ö(?=[a-zäöüß ])", "Oe")
                .replace("Ä(?=[a-zäöüß ])", "Ae");

        //now replace all the other capital umlaute
        output = output.replace("Ü", "UE")
                .replace("Ö", "OE")
                .replace("Ä", "AE");

        return output;
    }
}
