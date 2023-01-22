package com.antonio.fp.retrato.repositorios;

import com.antonio.fp.retrato.modelo.Usuario;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<Usuario, Long> {
    Usuario findByUsername(String username);
}
