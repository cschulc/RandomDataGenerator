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

import com.github.cschulc.domain.RandomStadt;
import com.github.cschulc.domain.RandomVorwahl;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataHolder {

    public final List<RandomStadt> staedte;
    public final List<String> bundeslaender;
    public final List<String> bundeslaender_ak;
    public final List<String> nachnamen;
    public final List<String> vorname_m;
    public final List<String> vorname_w;
    public final List<String> vornamen;
    public final List<String> woerter;
    public final List<String> laender;
    public final List<String> handyvorwahl_de;
    public final List<String> strassenendung;
    public final List<RandomVorwahl> vorwahl_stadt;
    public final List<String> domains;
    public final List<String> rechtsform;

    public DataHolder() {
        rechtsform = readLines("rechtsform.txt");
        laender = readLines("laender.txt");
        handyvorwahl_de = readLines("handyvorwahl_de.txt");
        staedte = readStaedte("plz_stadt.txt");
        vorname_m = readLines("vornamen_m.txt");
        vorname_w = readLines("vornamen_w.txt");
        vornamen = new ArrayList<>();
        vornamen.addAll(vorname_m);
        vornamen.addAll(vorname_w);
        bundeslaender_ak = readLines("bundeslaender_abk.txt");
        domains = readLines("domains.txt");
        nachnamen = readLines("nachnamen.txt");
        bundeslaender = readLines("bundeslaender.txt");
        woerter = readLines("lorem.txt");
        strassenendung = readLines("strassenendungen.txt");
        vorwahl_stadt = readVorwahlen("vorwahlen.txt");
    }

    private List<String> readLines(String filename) {
        List<String> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                retval.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retval;
    }

    private List<RandomStadt> readStaedte(String filename) {
        List<RandomStadt> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                retval.add(new RandomStadt(split[0], split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retval;
    }

    private List<RandomVorwahl> readVorwahlen(String filename) {
        List<RandomVorwahl> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                retval.add(new RandomVorwahl(split[0], split[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retval;
    }
}
