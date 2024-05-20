package com.teszta.tesztaapp.service;

import com.teszta.tesztaapp.model.Teszta;
import com.teszta.tesztaapp.repository.TesztaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TesztaServiceImplTest {

    @Mock
    private TesztaRepository tesztaRepository;

    @InjectMocks
    private TesztaServiceImpl tesztaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMentesTeszta() {
        Teszta teszta = new Teszta();
        when(tesztaRepository.save(any(Teszta.class))).thenReturn(teszta);

        Teszta savedTeszta = tesztaService.mentesTeszta(teszta);
        assertNotNull(savedTeszta);
        verify(tesztaRepository, times(1)).save(teszta);
    }

    @Test
    void testFinomak() {
        Teszta teszta1 = new Teszta();
        teszta1.setFinom(true);
        Teszta teszta2 = new Teszta();
        teszta2.setFinom(false);
        List<Teszta> tesztaList = List.of(teszta1, teszta2);

        when(tesztaRepository.findAll()).thenReturn(tesztaList);

        List<Teszta> finomak = tesztaService.finomak();
        assertEquals(1, finomak.size());
        assertTrue(finomak.get(0).isFinom());
    }

    @Test
    void testOsszesTeszta() {
        List<Teszta> tesztaList = new ArrayList<>();
        when(tesztaRepository.findAll()).thenReturn(tesztaList);

        List<Teszta> result = tesztaService.osszesTeszta();
        assertNotNull(result);
        verify(tesztaRepository, times(1)).findAll();
    }

    @Test
    void testTesztaTorles() {
        doNothing().when(tesztaRepository).deleteById(anyInt());

        String result = tesztaService.tesztaTorles(1);
        assertEquals("Tészta sikeresen törölve!", result);
        verify(tesztaRepository, times(1)).deleteById(1);
    }

    @Test
    void testTesztaFrissit() {
        Teszta teszta = new Teszta();
        when(tesztaRepository.save(any(Teszta.class))).thenReturn(teszta);

        Teszta updatedTeszta = tesztaService.tesztaFrissit(teszta);
        assertNotNull(updatedTeszta);
        verify(tesztaRepository, times(1)).save(teszta);
    }
}
