package com.dicoding.dhiandraaa.myquickcount;

import java.io.Serializable;

public class presiden implements Serializable {
    private String calon1;
    private String calon2;
    private String tidakSah;
    private String key;

    public presiden(){

    }

    public String getCalon1() {
        return calon1;
    }

    public void setCalon1(String calon1) {
        this.calon1 = calon1;
    }

    public String getCalon2() {
        return calon2;
    }

    public void setCalon2(String calon2) {
        this.calon2 = calon2;
    }

    public String getTidakSah() {
        return tidakSah;
    }

    public void setTidakSah(String tidakSah) {
        this.tidakSah = tidakSah;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return " "+calon1+"\n" +
                " "+calon2+"\n" +
                " "+tidakSah;
    }

    public presiden(String c1,String c2, String ts){
        calon1 = c1;
        calon2 = c2;
        tidakSah = ts;
    }
}
