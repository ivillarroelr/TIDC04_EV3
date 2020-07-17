package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Mensaje;

public interface IMensajeRepo extends JpaRepository<Mensaje, Integer>{
    
}