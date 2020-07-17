package me.ivillarroelr.prueba3.service;

import me.ivillarroelr.prueba3.model.Cuenta;

public interface ICuentaService extends ICRUD<Cuenta> {

    public String getMD5(String input);
    
}