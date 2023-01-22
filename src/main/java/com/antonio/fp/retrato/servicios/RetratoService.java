package com.antonio.fp.retrato.servicios;

import com.antonio.fp.retrato.modelo.Retrato;
import com.antonio.fp.retrato.repositorios.RetratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetratoService {
    @Autowired
    RetratoRepository repositorio;

    public void save(Retrato retrato){
        repositorio.save(retrato);
    }
}
