package com.teszta.tesztaapp.controller;

import java.util.List;

import com.teszta.tesztaapp.model.Teszta;
import com.teszta.tesztaapp.service.TesztaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teszta")
public class TesztaController {
    @Autowired
    private TesztaService tesztaService;

    @PostMapping("/add")
    public String add(@RequestBody Teszta teszta) {
        tesztaService.mentesTeszta(teszta);
        return "+1 eltárolt tészta.";
    }

    @GetMapping("/get")
    public List<Teszta> getTesztak() {
        return tesztaService.osszesTeszta();
    }

    @GetMapping("/getFinom")
    public List<Teszta> fintomTesztak() {
        return tesztaService.finomak();
    }

    @DeleteMapping("/del/{id}")
    public String tesztaTorles(@PathVariable Integer id) {
        return tesztaService.tesztaTorles(id);
    }

    @PutMapping("/update")
    public Teszta tesztaFrissit(@RequestBody Teszta teszta) {
        return tesztaService.tesztaFrissit(teszta);
    }
}
