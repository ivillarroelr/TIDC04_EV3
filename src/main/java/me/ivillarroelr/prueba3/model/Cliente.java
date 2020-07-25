package me.ivillarroelr.prueba3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cliente")
@DiscriminatorValue("2")
public class Cliente {

    @Id
    @Size(max = 20)
    private String rut;

    @OneToOne
    @MapsId
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="ejecutivoFK", nullable=false, foreignKey = @ForeignKey(name="FK_cliente_ejecutivo"))
    private Ejecutivo ejecutivoFK;

    @OneToMany(mappedBy="clienteFK", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Mensaje> mensaje = new HashSet<Mensaje>();

    @OneToMany(mappedBy="clienteFK", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Cuenta> cuenta = new HashSet<Cuenta>();

    public Ejecutivo getEjecutivoFK() {
        return ejecutivoFK;
    }

    public void setEjecutivoFK(Ejecutivo ejecutivoFK) {
        this.ejecutivoFK = ejecutivoFK;
    }

    public Set<Mensaje> getMensaje() {
        return mensaje;
    }

    public void setMensaje(Set<Mensaje> mensaje) {
        this.mensaje = mensaje;
    }

    public Set<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(Set<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}