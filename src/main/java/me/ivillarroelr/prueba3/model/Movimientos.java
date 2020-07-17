package me.ivillarroelr.prueba3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "movimientos")
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmovimiento;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "descripcion")
    @Size(max=200)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="cuentaFK", nullable=false, foreignKey = @ForeignKey(name="FK_movimientos_cuenta"))
    private Cuenta cuentaFK;

    public Integer getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(Integer idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuenta getCuentaFK() {
        return cuentaFK;
    }

    public void setCuentaFK(Cuenta cuentaFK) {
        this.cuentaFK = cuentaFK;
    }

}