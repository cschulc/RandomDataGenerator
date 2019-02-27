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

import com.github.cschulc.RandomDateTime;

import java.time.LocalDate;

public class RandomDateTimeImpl extends RandomBase implements RandomDateTime {

    LocalDate now = LocalDate.now();

    @Override
    public LocalDate getGeburtsdatum(int minAlter, int maxAlter) {
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
        return null;
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

    private LocalDate getDatum(int year) {
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


