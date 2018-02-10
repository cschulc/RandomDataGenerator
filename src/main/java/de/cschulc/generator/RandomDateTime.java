package de.cschulc.generator;

import java.time.LocalDate;

public interface RandomDateTime {

    LocalDate getGeburtsdatum(int minAlter, int maxAlter);

    LocalDate getGeburtsdatum(int minAlter);

    LocalDate getDatumInZukunft(int minMonate);

    LocalDate getDatumInVergangenheit(int minMonate);
}
