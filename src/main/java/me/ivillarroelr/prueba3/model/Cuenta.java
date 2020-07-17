package me.ivillarroelr.prueba3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    

    @Id
    private Integer numerocta;

    @Column(name = "saldo")
    private Integer saldo;

    @Column(name = "clavetransaccion")
    @Size(max=100)
    private String clavetransaccion;
    
    @Column(name = "saldolineacredito")
    private Integer saldolineacredito;
    
    @Column(name="saldolineacreidotusado")
    private Integer saldolineacreditousado;
    
    @Column(name="estado")
    private Integer estado;
    
    @ManyToOne
    @JoinColumn(name="clienteFK", nullable=false, foreignKey = @ForeignKey(name="FK_cuenta_cliente"))
    private Cliente clienteFK;

    @OneToMany(mappedBy="cuentaFK", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Movimientos> movimientos = new HashSet<Movimientos>();

    public Integer getNumerocta() {
        return numerocta;
    }

    public void setNumerocta(Integer numerocta) {
        this.numerocta = numerocta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getClavetransaccion() {
        return clavetransaccion;
    }

    public void setClavetransaccion(String clavetransaccion) {
        this.clavetransaccion = clavetransaccion;
    }

    public Integer getSaldolineacredito() {
        return saldolineacredito;
    }

    public void setSaldolineacredito(Integer saldolineacredito) {
        this.saldolineacredito = saldolineacredito;
    }

    public Integer getSaldolineacreditousado() {
        return saldolineacreditousado;
    }

    public void setSaldolineacreditousado(Integer saldolineacreditousado) {
        this.saldolineacreditousado = saldolineacreditousado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Cliente getClienteFK() {
        return clienteFK;
    }

    public void setClienteFK(Cliente clienteFK) {
        this.clienteFK = clienteFK;
    }

    public Set<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Set<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

}