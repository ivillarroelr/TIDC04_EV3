package me.ivillarroelr.prueba3.repo;

import me.ivillarroelr.prueba3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepo extends JpaRepository<Usuario,String> {
    public Optional<Usuario> findByRut(String rut);
}
