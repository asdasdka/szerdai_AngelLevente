package com.teszta.tesztaapp.service;

import com.teszta.tesztaapp.model.Teszta;

import java.util.List;

public interface TesztaService {
    public Teszta mentesTeszta(Teszta teszta);
    public List<Teszta> osszesTeszta();
}
