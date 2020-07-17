package me.ivillarroelr.prueba3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ivillarroelr.prueba3.model.Ejecutivo;
import me.ivillarroelr.prueba3.repo.IEjecutivoRepo;
import me.ivillarroelr.prueba3.service.IEjecutivoService;

@Service
public class EjecutivoServiceImpl implements IEjecutivoService {

    @Autowired
    private IEjecutivoRepo repo;

    @Override
    public Ejecutivo registrar(Ejecutivo ejecutivo) {
        return repo.save(ejecutivo);
    }

    @Override
    public Ejecutivo modificar(Ejecutivo ejecutivo) {
        return repo.save(ejecutivo);
    }

    @Override
    public List<Ejecutivo> listar() {
        return repo.findAll();
    }

    @Override
    public Ejecutivo leerPorId(String id) {
        Optional<Ejecutivo> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Ejecutivo();
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(id);
        return true;
    }

    
    
}