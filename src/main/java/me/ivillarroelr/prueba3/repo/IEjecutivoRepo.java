package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Ejecutivo;

public interface IEjecutivoRepo extends JpaRepository<Ejecutivo, String> {
    
}