package com.antonio.fp.retrato.servicios;

import com.antonio.fp.retrato.modelo.Retrato;
import com.antonio.fp.retrato.repositorios.RetratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class RetratoService {
    @Autowired
    RetratoRepository repositorio;

    public void save(Retrato retrato){
        repositorio.save(retrato);
    }
    @PreAuthorize("#entity.username == authentication.name")
    public void delete(Retrato entity) {repositorio.delete(entity);}
}
