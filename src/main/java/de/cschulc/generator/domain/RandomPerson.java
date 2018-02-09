package de.cschulc.generator.domain;

public class RandomPerson extends RandomAdresse {

    private String vorname;

    private String nachname;

    private String telefonnummer;

    private String handynummer;

    public RandomPerson(RandomAdresse adresse, String vorname, String nachname, String telefonnummer, String handynummer) {
        super(adresse);
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.handynummer = handynummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
}
