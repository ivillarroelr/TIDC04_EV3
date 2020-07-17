package me.ivillarroelr.prueba3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;


@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Size(max = 20)
    private String rut;

    @Column(name="nombre")
    @Size(max = 20)
    private String nombre;

    @Column(name="apellido")
    @Size(max = 20)
    private String apellido;

    @Column(name="clave")
    @Size(max = 100)
    private String clave;

    @ManyToOne
    @JoinColumn(name="ejecutivoFK", nullable=false, foreignKey = @ForeignKey(name="FK_cliente_ejecutivo"))
    private Ejecutivo ejecutivoFK;

    @OneToMany(mappedBy="clienteFK", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Mensaje> mensaje = new HashSet<Mensaje>();

    @OneToMany(mappedBy="clienteFK", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Cuenta> cuenta = new HashSet<Cuenta>();

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

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

    
}