package com.example.service;

import com.example.model.Biblioteci;
import com.example.model.Carti;
import com.example.repository.CartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AllService {

    @Autowired
    CartiRepository cartiRepository;

    List<Carti> cartiList = new ArrayList<>();

    public List<Carti> getCartiList() {
        return cartiRepository.findAll();
    }

    @Autowired
    com.example.repository.BibliotecaRepository BibliotecaRepository;

    List<Biblioteci> biblioteciList = new ArrayList<>();

    public List<Biblioteci> getBiblioteciList() {
        return BibliotecaRepository.findAll();
    }


    public void saveCarti(Carti carti) {
        cartiRepository.save(carti);
    }
    public void saveBiblioteci(Biblioteci biblioteci) {
        BibliotecaRepository.save(biblioteci);
    }
}


