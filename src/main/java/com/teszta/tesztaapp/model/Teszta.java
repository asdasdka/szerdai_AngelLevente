package com.teszta.tesztaapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teszta {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String marka;
    private String tipus;
    private int hanyTojasos;
    private int ar;
    private boolean finom;

    public Teszta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getHanyTojasos() {
        return hanyTojasos;
    }

    public void setHanyTojasos(int hanyTojasos) {
        this.hanyTojasos = hanyTojasos;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public boolean isFinom() {
        return finom;
    }

    public void setFinom(boolean finom) {
        this.finom = finom;
    }
}
