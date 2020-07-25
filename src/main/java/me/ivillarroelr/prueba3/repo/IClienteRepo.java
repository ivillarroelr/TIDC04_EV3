package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Cliente;

import java.util.Optional;

public interface IClienteRepo extends JpaRepository<Cliente,String> {
}