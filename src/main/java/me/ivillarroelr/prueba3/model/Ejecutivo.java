package me.ivillarroelr.prueba3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "ejecutivo")
@DiscriminatorValue("1")
public class Ejecutivo {

    @Id
    @Size(max = 20)
    private String rut;

    @OneToOne
    @MapsId
    private Usuario usuario;

    @OneToMany(mappedBy="ejecutivoFK", cascade = { CascadeType.PERSIST }, orphanRemoval = false)
    private Set<Cliente> clientes = new HashSet<Cliente>();

    @OneToMany(mappedBy="ejecutivoFK", cascade = { CascadeType.PERSIST }, orphanRemoval = false)
    private Set<Mensaje> mensaje = new HashSet<Mensaje>();

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Set<Mensaje> getMensaje() {
        return mensaje;
    }

    public void setMensaje(Set<Mensaje> mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}