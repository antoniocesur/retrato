package com.antonio.fp.retrato.repositorios;

import com.antonio.fp.retrato.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<Usuario, Long> {
}
