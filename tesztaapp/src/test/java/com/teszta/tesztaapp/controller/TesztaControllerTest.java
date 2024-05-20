package com.teszta.tesztaapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teszta.tesztaapp.model.Teszta;
import com.teszta.tesztaapp.service.TesztaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TesztaController.class)
public class TesztaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TesztaService tesztaService;

    @Autowired
    private ObjectMapper objectMapper;

    private Teszta teszta;

    @BeforeEach
    public void setUp() {
        teszta = new Teszta();
        teszta.setId(1);
        teszta.setTipus("Spaghetti");
        // Set other fields as necessary
    }

    @Test
    public void testAddTeszta() throws Exception {
        mockMvc.perform(post("/teszta/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teszta)))
                .andExpect(status().isOk())
                .andExpect(content().string("+1 eltárolt tészta."));
    }

    @Test
    public void testGetTesztak() throws Exception {
        List<Teszta> tesztak = Arrays.asList(teszta);
        when(tesztaService.osszesTeszta()).thenReturn(tesztak);

        mockMvc.perform(get("/teszta/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipus").value("Spaghetti"))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    public void testGetFinomTesztak() throws Exception {
        List<Teszta> tesztak = Arrays.asList(teszta);
        when(tesztaService.finomak()).thenReturn(tesztak);

        mockMvc.perform(get("/teszta/getFinom"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tipus").value("Spaghetti"))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    public void testDeleteTeszta() throws Exception {
        when(tesztaService.tesztaTorles(1)).thenReturn("Tészta törölve.");

        mockMvc.perform(delete("/teszta/del/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Tészta törölve."));
    }

    @Test
    public void testUpdateTeszta() throws Exception {
        when(tesztaService.tesztaFrissit(any(Teszta.class))).thenReturn(teszta);

        mockMvc.perform(put("/teszta/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(teszta)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipus").value("Spaghetti"))
                .andExpect(jsonPath("$.id").value(1));
    }
}
