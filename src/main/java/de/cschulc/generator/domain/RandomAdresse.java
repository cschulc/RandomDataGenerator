package de.cschulc.generator.domain;

public class RandomAdresse {

    private String strasse;

    private String hausnummer;

    private String postleitzahl;

    private String stadt;

    public RandomAdresse(String strasse, String hausnummer, String postleitzahl, String stadt) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        this.stadt = stadt;
    }

    public RandomAdresse(RandomAdresse adresse) {
        this.hausnummer = adresse.hausnummer;
        this.postleitzahl = adresse.postleitzahl;
        this.stadt = adresse.stadt;
        this.strasse = adresse.strasse;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public String getStadt() {
        return stadt;
    }
}
