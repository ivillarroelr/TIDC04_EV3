package me.ivillarroelr.prueba3.service;

import java.util.List;

public interface ICRUD<T> {
    
    T registrar(T obj);
    T modificar(T obj);
    List<T> listar();
    T leerPorId(String id);
    boolean eliminar(String id);
    
}