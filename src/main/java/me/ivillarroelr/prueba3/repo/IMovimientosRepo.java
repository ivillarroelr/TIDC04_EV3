package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Movimientos;

public interface IMovimientosRepo extends JpaRepository<Movimientos, Integer> {
    
}