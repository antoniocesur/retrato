package com.antonio.fp.retrato.repositorios;

import com.antonio.fp.retrato.modelo.Retrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetratoRepository extends JpaRepository<Retrato, Long> {

}
