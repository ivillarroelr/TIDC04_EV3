package me.ivillarroelr.prueba3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ivillarroelr.prueba3.model.Mensaje;
import me.ivillarroelr.prueba3.repo.IMensajeRepo;
import me.ivillarroelr.prueba3.service.IMensajeService;

@Service
public class MensajeServiceImpl implements IMensajeService{

    @Autowired
    private IMensajeRepo repo;

    @Override
    public Mensaje registrar(Mensaje mensaje) {
        return repo.save(mensaje);
    }

    @Override
    public Mensaje modificar(Mensaje mensaje) {
        return repo.save(mensaje);
    }

    @Override
    public List<Mensaje> listar() {
        return repo.findAll();
    }

    @Override
    public Mensaje leerPorId(String id) {
        Optional<Mensaje> op = repo.findById(Integer.parseInt(id));
        return op.isPresent() ? op.get() : new Mensaje();
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(Integer.parseInt(id));
        return true;
    }


}