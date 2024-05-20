package com.teszta.tesztaapp.service;

import java.util.List;

import com.teszta.tesztaapp.model.Teszta;

public interface TesztaService {
    public Teszta mentesTeszta(Teszta teszta);

    public List<Teszta> finomak();

    public List<Teszta> osszesTeszta();

    public String tesztaTorles(Integer id);

    public Teszta tesztaFrissit(Teszta teszta);
}
