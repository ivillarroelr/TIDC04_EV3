package me.ivillarroelr.prueba3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ivillarroelr.prueba3.model.Cliente;
import me.ivillarroelr.prueba3.repo.IClienteRepo;
import me.ivillarroelr.prueba3.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    public Cliente registrar(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente modificar(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente leerPorId(String id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Cliente();
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(id);
        return true;
    }
    
}