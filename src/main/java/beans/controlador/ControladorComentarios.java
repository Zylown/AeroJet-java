package beans.controlador;

import bean.dao.ComentariosDao;
import beans.modelo.Comentarios;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "comentario_controlador", eager = true)
@ViewScoped
public class ControladorComentarios implements Serializable {

    private SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");

    private List<Comentarios> comentarios;
    private ComentariosDao comentariosdao;

    private String comentario;
    private Date fecha;
    private Comentarios comentariosSeleccionada;
    private int id;

    public SimpleDateFormat getDateFormato() {
        return dateFormato;
    }

    public void setDateFormato(SimpleDateFormat dateFormato) {
        this.dateFormato = dateFormato;
    }

    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    public ComentariosDao getComentariosdao() {
        return comentariosdao;
    }

    public void setComentariosdao(ComentariosDao comentariosdao) {
        this.comentariosdao = comentariosdao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comentarios getComentariosSeleccionada() {
        return comentariosSeleccionada;
    }

    public void setComentariosSeleccionada(Comentarios comentariosSeleccionada) {
        this.comentariosSeleccionada = comentariosSeleccionada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PostConstruct
    public void init() {
        comentariosdao = new ComentariosDao();
        comentarios = comentariosdao.getAllComentarios();

    }

    public void agregarComentarios(String comentario, Date fecha) throws IOException, ParseException {
        Comentarios nuevoComentarios = new Comentarios();
        nuevoComentarios.setComentario(comentario);
        nuevoComentarios.setFecha(dateFormato.parse(dateFormato.format(fecha)));

        // Aquí puedes llamar a tu servicio de AvionDao y utilizar el método agregarAvion() para insertar el nuevo avión en la base de datos
        comentariosdao.agregarComentarios(comentario, fecha);
        
        // Obtener la lista de usuarios actualizada de la base de datos
        comentarios = comentariosdao.getAllComentarios();
        
        // Restablecer los campos del formulario
        /*descripcion = "";*/

        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }

    public void actualizarComentarios(int id, String comentario, Date fecha) throws IOException, ParseException {
        Comentarios nuevoComentarios = new Comentarios();
        nuevoComentarios.setId(id);
        nuevoComentarios.setComentario(comentario);
        nuevoComentarios.setFecha(dateFormato.parse(dateFormato.format(fecha)));
        
        comentariosdao.actualizarComentarios(id, comentario, fecha);
        FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "comentarios actualizado correctamente", null));
    }

    public void eliminarComentarios(int idn, AjaxBehaviorEvent event) {
        ComentariosDao serviceComentarios = new ComentariosDao();
        serviceComentarios.eliminarComentarios(idn);
        
        // Obtener la lista de usuarios actualizada de la base de datos
        comentarios = comentariosdao.getAllComentarios();
        FacesContext.getCurrentInstance().addMessage("formEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "comentarios eliminado correctamente", null));
    }

}
