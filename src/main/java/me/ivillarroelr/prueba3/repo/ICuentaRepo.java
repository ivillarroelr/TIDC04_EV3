package me.ivillarroelr.prueba3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.ivillarroelr.prueba3.model.Cuenta;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ICuentaRepo extends JpaRepository<Cuenta, Integer> {
    @Query(value="SELECT * FROM cuenta WHERE clientefk= :rut", nativeQuery = true )
    public Set<Cuenta> cuentasUsuario(String rut);
}