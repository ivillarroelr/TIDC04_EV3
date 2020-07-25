package me.ivillarroelr.prueba3.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ivillarroelr.prueba3.model.Cuenta;
import me.ivillarroelr.prueba3.repo.ICuentaRepo;
import me.ivillarroelr.prueba3.service.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaRepo repo;

    @Override
    public Cuenta registrar(Cuenta cuenta) {
        return repo.save(cuenta);
    }

    @Override
    public Cuenta modificar(Cuenta cuenta) {
        return repo.save(cuenta);
    }

    @Override
    public List<Cuenta> listar() {
        return repo.findAll();
    }

    @Override
    public Cuenta leerPorId(String id) {
        Optional<Cuenta> op = repo.findById(Integer.parseInt(id));
        return op.isPresent() ? op.get() : new Cuenta();
    }

    @Override
    public boolean eliminar(String id) {
        repo.deleteById(Integer.parseInt(id));
        return true;
    }

    public String getMD5(String input) {
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
       
        while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
        }
        return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public Set<Cuenta> cuentasUsuario(String rut) {
        return repo.cuentasUsuario(rut);
    }
}