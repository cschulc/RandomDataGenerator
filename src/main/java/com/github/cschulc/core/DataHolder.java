package com.github.cschulc.core;

import com.github.cschulc.domain.RandomStadt;
import com.github.cschulc.domain.RandomVorwahl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    private static DataHolder instance;

    public static DataHolder getInstance() {
        if (instance == null) {
            synchronized (DataHolder.class) {
                instance = new DataHolder();
            }
        }
        return instance;
    }

    private DataHolder() {
        rechtsform = DataHolder.readLines("rechtsform.txt");
        laender = DataHolder.readLines("laender.txt");
        handyvorwahl_de = DataHolder.readLines("handyvorwahl_de.txt");
        staedte = DataHolder.readStaedte("plz_stadt.txt");
        vorname_m = DataHolder.readLines("vornamen_m.txt");
        vorname_w = DataHolder.readLines("vornamen_w.txt");
        vornamen = new ArrayList<>();
        vornamen.addAll(vorname_m);
        vornamen.addAll(vorname_w);
        bundeslaender_ak = DataHolder.readLines("bundeslaender_abk.txt");
        domains = DataHolder.readLines("domains.txt");
        nachnamen = DataHolder.readLines("nachnamen.txt");
        bundeslaender = DataHolder.readLines("bundeslaender.txt");
        woerter = DataHolder.readLines("lorem.txt");
        strassenendung = DataHolder.readLines("strassenendungen.txt");
        vorwahl_stadt = DataHolder.readVorwahlen("vorwahlen.txt");
    }

    private static List<String> readLines(String filename) {
        List<String> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            FileReader fileReader = new FileReader(path + filename);
            bufferedReader = new BufferedReader(fileReader);
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

    private static List<RandomStadt> readStaedte(String filename) {
        List<RandomStadt> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            FileReader fileReader = new FileReader(path + filename);
            bufferedReader = new BufferedReader(fileReader);
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

    private static List<RandomVorwahl> readVorwahlen(String filename) {
        List<RandomVorwahl> retval = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            FileReader fileReader = new FileReader(path + filename);
            bufferedReader = new BufferedReader(fileReader);
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
