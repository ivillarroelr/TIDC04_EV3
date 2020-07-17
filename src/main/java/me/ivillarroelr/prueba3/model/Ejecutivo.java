package me.ivillarroelr.prueba3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ejecutivo")
public class Ejecutivo {

    @Id
    @Size(max=20)
    private String rut;

    @Column(name = "nombre")
    @Size(max=20)
    private String nombre;

    @Column(name = "apellido")
    @Size(max=20)
    private String apellido;

    @Column(name = "clave")
    @Size(max=100)
    private String clave;

    @OneToMany(mappedBy="ejecutivoFK", cascade = { CascadeType.PERSIST }, orphanRemoval = false)
    private Set<Cliente> cliente = new HashSet<Cliente>();

    @OneToMany(mappedBy="ejecutivoFK", cascade = { CascadeType.PERSIST }, orphanRemoval = false)
    private Set<Mensaje> mensaje = new HashSet<Mensaje>();

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

    public Set<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(Set<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Set<Mensaje> getMensaje() {
        return mensaje;
    }

    public void setMensaje(Set<Mensaje> mensaje) {
        this.mensaje = mensaje;
    }

    
    
}