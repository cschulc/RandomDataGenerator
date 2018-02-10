package de.cschulc.generator;

import java.time.LocalDate;

public class RandomTimeDataImpl extends RandomBase implements RandomTimeData {

    LocalDate now = LocalDate.now();

    @Override
    public LocalDate getGeburtsdatum(int minAlter, int maxAlter) {
        int month = random.nextInt(12);
        int day;

        if (month != 2) {
            if (month % 2 == 0) {
                day = random.nextInt(30);
            } else {
                day = random.nextInt(31);
            }
        } else {
            day = random.nextInt(28);
        }
        int alter = random.nextInt(maxAlter);
        if (alter < minAlter) {
            alter = minAlter;
        }
        int year = now.getYear() - alter;
        return LocalDate.of(year, month, day);
    }

    @Override
    public LocalDate getGeburtsdatum(int minAlter) {
        return getGeburtsdatum(minAlter, 100);
    }

    @Override
    public LocalDate getDatumInZukunft(int minMonate) {
        return null;
    }

    @Override
    public LocalDate getDatumInVergangenheit(int minMonate) {
        return null;
    }

    private LocalDate getDatum(int year){
        int month = random.nextInt(12);
        int day;

        if (month != 2) {
            if (month % 2 == 0) {
                day = random.nextInt(30);
            } else {
                day = random.nextInt(31);
            }
        } else {
            day = random.nextInt(28);
        }
        return LocalDate.of(year, month, day);
    }
}


