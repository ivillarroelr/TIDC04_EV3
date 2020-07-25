package me.ivillarroelr.prueba3.service;

import me.ivillarroelr.prueba3.model.Cuenta;

import java.util.Set;

public interface ICuentaService extends ICRUD<Cuenta> {

    public String getMD5(String input);

    public Set<Cuenta> cuentasUsuario(String rut);
}