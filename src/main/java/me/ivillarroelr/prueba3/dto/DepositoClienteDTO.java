package me.ivillarroelr.prueba3.dto;

import java.io.Serializable;
import java.util.Objects;

public class DepositoClienteDTO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cuentaorigen;
    private String cuentadestino;
    private String monto;


    public String getCuentaorigen() {
        return cuentaorigen;
    }

    public void setCuentaorigen(String cuentaorigen) {
        this.cuentaorigen = cuentaorigen;
    }

    public String getCuentadestino() {
        return cuentadestino;
    }

    public void setCuentadestino(String cuentadestino) {
        this.cuentadestino = cuentadestino;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepositoClienteDTO that = (DepositoClienteDTO) o;
        return cuentaorigen.equals(that.cuentaorigen) &&
                cuentadestino.equals(that.cuentadestino) &&
                monto.equals(that.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaorigen, cuentadestino, monto);
    }
}