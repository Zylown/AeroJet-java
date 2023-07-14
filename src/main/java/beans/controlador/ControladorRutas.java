
package beans.controlador;

import bean.dao.RutaDao;
import beans.modelo.Rutas;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "ruta_controlador", eager = true)
@ViewScoped
public class ControladorRutas implements Serializable{
    private List<Rutas> rutas;
    private RutaDao rutadao;
    private String puntoOrigen;
    private String puntoDestino;
    private int distancia;
    private int duracionEstimada;
    private Rutas rutaSeleccionada;
    private int id;

    public List<Rutas> getRutas() {
        return rutas;
    }

    public void setRutas(List<Rutas> rutas) {
        this.rutas = rutas;
    }

    public RutaDao getRutadao() {
        return rutadao;
    }

    public void setRutadao(RutaDao rutadao) {
        this.rutadao = rutadao;
    }

    public String getPuntoOrigen() {
        return puntoOrigen;
    }

    public void setPuntoOrigen(String puntoOrigen) {
        this.puntoOrigen = puntoOrigen;
    }

    public String getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(String puntoDestino) {
        this.puntoDestino = puntoDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Rutas getRutaSeleccionada() {
        return rutaSeleccionada;
    }

    public void setRutaSeleccionada(Rutas rutaSeleccionada) {
        this.rutaSeleccionada = rutaSeleccionada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


   @PostConstruct
    public void init() {
       rutadao = new RutaDao();
        rutas = rutadao.getAllRutas();

    }
    public void agregarRuta(String puntoOrigen, String puntoDestino, int distancia, int duracionEstimada) throws IOException {
        Rutas nuevoRuta = new Rutas();
        nuevoRuta.setPuntoOrigen(puntoOrigen);
        nuevoRuta.setPuntoDestino(puntoDestino);
        nuevoRuta.setDistancia(distancia);
        nuevoRuta.setDuracionEstimada(duracionEstimada);

        // Aquí puedes llamar a tu servicio de AvionDao y utilizar el método agregarAvion() para insertar el nuevo avión en la base de datos
        rutadao.agregarRuta(nuevoRuta.getPuntoOrigen(), nuevoRuta.getPuntoDestino(), nuevoRuta.getDistancia(), nuevoRuta.getDuracionEstimada());

        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }

    public void actualizarRuta(Integer id, String puntoOrigen, String puntoDestino, Integer distancia, Integer duracionEstimada) throws IOException {
        Rutas rutaExistente = rutadao.obtenerRutaPorId(id);

        // Verificar si el avión existe
        if (rutaExistente == null) {
            FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, "El RUTAS no existe", null));
            return;
        }

        // Asignar los nuevos valores al avión existente
        rutaExistente.setPuntoOrigen(puntoOrigen);
        rutaExistente.setPuntoDestino(puntoDestino);
        rutaExistente.setDistancia(distancia);
        rutaExistente.setDuracionEstimada(duracionEstimada);

        // Llamar al método de actualización en el avionDao
        rutadao.actualizarRuta(rutaExistente.getId(), rutaExistente.getPuntoOrigen(), rutaExistente.getPuntoDestino(), rutaExistente.getDistancia(), rutaExistente.getDuracionEstimada());

        FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Ruta actualizado correctamente", null));
    }

    public void eliminarRuta(int id, AjaxBehaviorEvent event) {
        rutadao.eliminarRuta(id);
        FacesContext.getCurrentInstance().addMessage("formEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "Ruta eliminado correctamente", null));
    }
    
}
