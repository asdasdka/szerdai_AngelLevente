package com.teszta.tesztaapp.service;

import com.teszta.tesztaapp.model.Teszta;
import com.teszta.tesztaapp.repository.TesztaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TesztaServiceImpl implements TesztaService{

    @Autowired
    private TesztaRepository tesztaRepository;

    @Override
    public Teszta mentesTeszta(Teszta teszta) {
        return tesztaRepository.save(teszta);
    }

    @Override
    public List<Teszta> finomak() {
        List<Teszta> finomLista = new ArrayList<>();
        for (Teszta teszta: osszesTeszta()){
            if (teszta.isFinom()){
                finomLista.add(teszta);
            }
        }
        return finomLista;
    }

    @Override
    public List<Teszta> osszesTeszta() {
        return tesztaRepository.findAll();
    }

    @Override
    public String tesztaTorles(Integer id) {
        tesztaRepository.deleteById(id);
        return "Tészta sikeresen törölve!";
    }

    @Override
    public Teszta tesztaFrissit(Teszta teszta) {
        return tesztaRepository.save(teszta);
    }
}
