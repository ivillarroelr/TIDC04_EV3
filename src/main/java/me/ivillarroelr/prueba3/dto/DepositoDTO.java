package me.ivillarroelr.prueba3.dto;

import java.io.Serializable;

public class DepositoDTO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String numeroCuenta;
    private String monto;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((monto == null) ? 0 : monto.hashCode());
        result = prime * result + ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DepositoDTO other = (DepositoDTO) obj;
        if (monto == null) {
            if (other.monto != null)
                return false;
        } else if (!monto.equals(other.monto))
            return false;
        if (numeroCuenta == null) {
            if (other.numeroCuenta != null)
                return false;
        } else if (!numeroCuenta.equals(other.numeroCuenta))
            return false;
        return true;
    }

    
    
}