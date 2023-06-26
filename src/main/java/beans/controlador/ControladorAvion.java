package beans.controlador;

import bean.dao.AvionDao;
import beans.modelo.Aviones;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "avion_controlador", eager = true)
@ViewScoped

public class ControladorAvion implements Serializable {

    private List<Aviones> aviones;
    private AvionDao avionDao;
    private String modelo;
    private int capacidad;
    private String estado;
    private Aviones avionSeleccionado; 
    private int id;

    public List<Aviones> getAviones() {
        return aviones;
    }

    public void setAviones(List<Aviones> aviones) {
        this.aviones = aviones;
    }

    public AvionDao getAvionDao() {
        return avionDao;
    }

    public void setAvionDao(AvionDao avionDao) {
        this.avionDao = avionDao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aviones getAvionSeleccionado() {
        return avionSeleccionado;
    }

    public void setAvionSeleccionado(Aviones avionSeleccionado) {
        this.avionSeleccionado = avionSeleccionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PostConstruct
    public void init() {
        avionDao = new AvionDao();
        aviones = avionDao.getAllAviones();

    }

    public void agregar(String modelo, int capacidad, String estado) throws IOException {
        Aviones nuevoAvion = new Aviones();
        nuevoAvion.setModelo(modelo);
        nuevoAvion.setCapacidad(capacidad);
        nuevoAvion.setEstado(estado);

        // Aquí puedes llamar a tu servicio de AvionDao y utilizar el método agregarAvion() para insertar el nuevo avión en la base de datos
        avionDao.agregarAvion(nuevoAvion.getModelo(), nuevoAvion.getCapacidad(), nuevoAvion.getEstado());

        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }

    public void actualizarAvion(int id, String modelo, int capacidad, String estado) throws IOException {
        Aviones avionExistente = avionDao.obtenerAvionPorId(id);

        // Verificar si el avión existe
        if (avionExistente == null) {
            FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, "El avión no existe", null));
            return;
        }

        // Asignar los nuevos valores al avión existente
        avionExistente.setModelo(modelo);
        avionExistente.setCapacidad(capacidad);
        avionExistente.setEstado(estado);

        // Llamar al método de actualización en el avionDao
        avionDao.actualizarAvion(avionExistente.getId(), avionExistente.getModelo(), avionExistente.getCapacidad(), avionExistente.getEstado());

        FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Avión actualizado correctamente", null));
    }

    public void eliminarAvion(int id) {
        avionDao.eliminarAvion(id);
        FacesContext.getCurrentInstance().addMessage("formEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "Avion eliminado correctamente", null));
    }
}
