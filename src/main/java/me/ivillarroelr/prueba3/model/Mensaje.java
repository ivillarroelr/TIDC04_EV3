package me.ivillarroelr.prueba3.model;

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
@Table(name = "mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmensaje;

    @Column(name = "asunto")
    @Size(max=20)
    private String asunto;

    @Column(name = "contenido")
    @Size(max=200)
    private String contenido;

    @Column(name = "respuesta")
    @Size(max=200)
    private String respuesta;

    @ManyToOne
    @JoinColumn(name="clienteFK", nullable=false, foreignKey = @ForeignKey(name="FK_mensaje_cliente"))
    private Cliente clienteFK;

    @ManyToOne
    @JoinColumn(name="ejecutivoFK", nullable=false, foreignKey = @ForeignKey(name="FK_mensaje_ejecutivo"))
    private Ejecutivo ejecutivoFK;

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Cliente getClienteFK() {
        return clienteFK;
    }

    public void setClienteFK(Cliente clienteFK) {
        this.clienteFK = clienteFK;
    }

    public Ejecutivo getEjecutivoFK() {
        return ejecutivoFK;
    }

    public void setEjecutivoFK(Ejecutivo ejecutivoFK) {
        this.ejecutivoFK = ejecutivoFK;
    }


    
}