package com.github.cschulc.core;

import com.github.cschulc.RandomDateTime;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;

public class RandomDateTimeImpl extends RandomBase implements RandomDateTime {

    LocalDate now = LocalDate.now();

    @Override
    public LocalDate getGeburtsdatum(int minAlter, int maxAlter) {
        throw new NotImplementedException();
/*        // Bestimmen des Geburtsjahres
        int alter = random.nextInt(maxAlter);
        if (alter < minAlter) {
            alter = minAlter;
        }
        int year = now.getYear() - alter;
        // falls aktuellen Jahr - Geburtsjahr gleich minAlter ist muss der Geburtsmonat kleiner gleich dem aktuellen Monat sein.
        int month;
        int day;
        if(now.getYear() - year == minAlter){
            month = random.nextInt(now.getMonthValue());
            // falls das aktuelle Jahr minus dem minAlter ist und der Moant gleich ist, darf der Tag nur kleiner gleich dem aktuellen Tag sein.
            if(month == now.getMonthValue()){
                day = random.nextInt(now.getDayOfMonth());
            }
            else{
                day = getDay(month);
            }
        }else{
            month = random.nextInt(12);
            day = getDay(month);
        }
        return LocalDate.of(year, month, day);*/
    }



    @Override
    public LocalDate getGeburtsdatum(int minAlter) {
        return getGeburtsdatum(minAlter, 100);
    }

    @Override
    public LocalDate getDatumInZukunft(int minMonate) {
        throw new NotImplementedException();
    }

    @Override
    public LocalDate getDatumInVergangenheit(int minMonate) {
        throw new NotImplementedException();
    }

    private LocalDate getDatum(int year){
        int month = random.nextInt(12);
        int day;

        day = getDay(month);
        return LocalDate.of(year, month, day);
    }

    /**
     * Liefert den Tag in Abhaengigkeit zum Monat.
     *
     * @param month
     * @return
     */
    private int getDay(int month) {
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
        return day;
    }
}


