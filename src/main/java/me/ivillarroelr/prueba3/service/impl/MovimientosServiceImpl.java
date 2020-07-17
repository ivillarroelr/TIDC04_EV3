package me.ivillarroelr.prueba3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ivillarroelr.prueba3.model.Movimientos;
import me.ivillarroelr.prueba3.repo.IMovimientosRepo;
import me.ivillarroelr.prueba3.service.IMovimientosService;

@Service
public class MovimientosServiceImpl implements IMovimientosService {

    @Autowired
    private IMovimientosRepo repo;

    @Override
    public Movimientos registrar(Movimientos movimientos) {
        return repo.save(movimientos);
    }

    @Override
    public Movimientos modificar(Movimientos movimientos) {
        return repo.save(movimientos);
    }

    @Override
    public List<Movimientos> listar() {
        return repo.findAll();
    }

    @Override
    public Movimientos leerPorId(String id) {
        Optional<Movimientos> op = repo.findById(Integer.parseInt(id));
        return op.isPresent() ? op.get() : new Movimientos();
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(Integer.parseInt(id));
        return true;
    }


    
}