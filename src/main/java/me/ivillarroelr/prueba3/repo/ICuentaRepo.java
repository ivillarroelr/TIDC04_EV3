package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Cuenta;

public interface ICuentaRepo extends JpaRepository<Cuenta, Integer> {
    
}