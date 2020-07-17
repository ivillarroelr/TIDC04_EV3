package me.ivillarroelr.prueba3.dto;

import java.io.Serializable;

public class EjecutivoDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String rut;
    private String clave;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
        result = prime * result + ((rut == null) ? 0 : rut.hashCode());
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
        EjecutivoDTO other = (EjecutivoDTO) obj;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        if (rut == null) {
            if (other.rut != null)
                return false;
        } else if (!rut.equals(other.rut))
            return false;
        return true;
    }

    
    
}