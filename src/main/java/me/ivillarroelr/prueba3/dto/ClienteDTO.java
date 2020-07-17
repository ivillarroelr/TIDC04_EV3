package me.ivillarroelr.prueba3.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String rut;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        ClienteDTO other = (ClienteDTO) obj;
        if (rut == null) {
            if (other.rut != null)
                return false;
        } else if (!rut.equals(other.rut))
            return false;
        return true;
    }

    
    
}