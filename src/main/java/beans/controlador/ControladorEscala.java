/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.controlador;

import bean.dao.EscalaDao;
import beans.modelo.Escalas;
import beans.modelo.Vuelos;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
@ManagedBean(name = "escala_controlador", eager = true)
@ViewScoped
public class ControladorEscala implements Serializable{
    private List<Escalas> escalas;
    private Escalas escalaSeleccionada;
    private EscalaDao escaladao;
    private int id;
    private String ciudad;
    private int duracion;
    private int vueloid;
    

    public int getVueloid() {
        return vueloid;
    }

    public void setVueloid(int vueloid) {
        this.vueloid = vueloid;
    }

    public List<Escalas> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escalas> escalas) {
        this.escalas = escalas;
    }

    public Escalas getEscalaSeleccionada() {
        return escalaSeleccionada;
    }

    public void setEscalaSeleccionada(Escalas escalaSeleccionada) {
        this.escalaSeleccionada = escalaSeleccionada;
    }

    public EscalaDao getEscaladao() {
        return escaladao;
    }

    public void setEscaladao(EscalaDao escaladao) {
        this.escaladao = escaladao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    @PostConstruct
    public void init() {
        escaladao = new EscalaDao();
        escalas = escaladao.getAllEscalas();
    }
    public void agregar(String ciudad, int duracion, int vueloID) throws IOException {
        Escalas nuevaEscala = new Escalas();
        nuevaEscala.setCiudad(ciudad);
        nuevaEscala.setDuracion(duracion);
        nuevaEscala.setVueloID(vueloID);

        // Aquí puedes llamar a tu servicio de AvionDao y utilizar el método agregarAvion() para insertar el nuevo avión en la base de datos
        escaladao.agregarEscala(nuevaEscala.getCiudad(), nuevaEscala.getDuracion(), nuevaEscala.getVueloID());

        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }

    public void actualizarEscala(int id, String ciudad, int duracion, int vueloid) throws IOException {
        Escalas escalaExistente = escaladao.obtenerEscalaPorId(id);

        // Verificar si el avión existe
        if (escalaExistente == null) {
            FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, "La escala no existe", null));
            return;
        }

        // Asignar los nuevos valores al avión existente
        escalaExistente.setCiudad(ciudad);
        escalaExistente.setDuracion(duracion);
        escalaExistente.setVueloID(vueloid);

        // Llamar al método de actualización en el avionDao
        escaladao.actualizarEscala(escalaExistente.getId(), escalaExistente.getCiudad(), escalaExistente.getDuracion(), escalaExistente.getVueloID());

        FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Escala actualizada correctamente", null));
    }

    public void eliminarEscala(int id) {
        escaladao.eliminarEscala(id);
        FacesContext.getCurrentInstance().addMessage("formEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "Avion eliminado correctamente", null));
    }
            
}
