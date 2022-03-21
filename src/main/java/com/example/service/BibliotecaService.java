/*package com.example.service;

import com.example.model.Biblioteci;
import com.example.repository.BibliotecaRepository;
import com.example.repository.CartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BiblioteciService {

    @Autowired
    BibliotecaRepository BibliotecaRepository;

    List<Biblioteci> biblioteciList = new ArrayList<>();
    public List<Biblioteci> getBiblioteciList(){
        return BiblioteciRepository.findAll();
    }

    public void saveBiblioteci(Biblioteci biblioteci) {
        BibliotecaRepository.save(biblioteci);
    }
}*/
