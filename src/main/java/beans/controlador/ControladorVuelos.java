package beans.controlador;

import bean.dao.VuelosDao;
import beans.modelo.Vuelos;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "vuelos_controlador", eager = true)
@ViewScoped
public class ControladorVuelos implements Serializable {

    private SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");

    private List<Vuelos> vuelos;
    private VuelosDao vuelosdao;

    private Date fechaSalida;
    private Time horaSalida;
    private Date fechaLlegada;
    private Time horaLlegada;
    private Date fechaReprogramacion;
    private String estado;

    private Vuelos VuelosSeleccionada;
    private int id;

    public SimpleDateFormat getDateFormato() {
        return dateFormato;
    }

    public void setDateFormato(SimpleDateFormat dateFormato) {
        this.dateFormato = dateFormato;
    }

    public List<Vuelos> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelos> vuelos) {
        this.vuelos = vuelos;
    }

    public VuelosDao getVuelosdao() {
        return vuelosdao;
    }

    public void setVuelosdao(VuelosDao vuelosdao) {
        this.vuelosdao = vuelosdao;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getFechaReprogramacion() {
        return fechaReprogramacion;
    }

    public void setFechaReprogramacion(Date fechaReprogramacion) {
        this.fechaReprogramacion = fechaReprogramacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vuelos getVuelosSeleccionada() {
        return VuelosSeleccionada;
    }

    public void setVuelosSeleccionada(Vuelos VuelosSeleccionada) {
        this.VuelosSeleccionada = VuelosSeleccionada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PostConstruct
    public void init() {
        vuelosdao = new VuelosDao();
        vuelos = vuelosdao.getAllVuelos();

    }

    public void Cuentavalidar(String estado) throws IOException {
        boolean validacuenta = false;

        vuelosdao = new VuelosDao();
        vuelos = vuelosdao.getAllVuelos();

        for (Vuelos vuelo : vuelos) {
            if (vuelo.getEstado().equals(estado)) {
                validacuenta = true;
                break;
            }
        }

        if (validacuenta) {
            if (estado.equals("Operativo")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/AeroJet-Java/faces/resources/pages/vista-administrador/admvuelo1.xhtml");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/AeroJet-Java/faces/resources/pages/vista-administrador/admvuelo.xhtml");
            }
            FacesContext.getCurrentInstance().responseComplete();
        } else {
            FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Estado no encontrado ", null));
        }
    }

    public void agregarVuelos(Date fechaSalida, Time horaSalida, Date fechaLlegada, Time horaLlegada, Date fechaReprogramacion, String estado) throws IOException, ParseException {
        Vuelos nuevoVuelos = new Vuelos();

        nuevoVuelos.setFechaSalida(dateFormato.parse(dateFormato.format(fechaSalida)));
        nuevoVuelos.setHoraSalida((Time) dateFormato.parse(dateFormato.format(horaSalida)));
        nuevoVuelos.setFechaLlegada(dateFormato.parse(dateFormato.format(fechaLlegada)));
        nuevoVuelos.setHoraLlegada((Time) dateFormato.parse(dateFormato.format(horaLlegada)));
        nuevoVuelos.setFechaReprogramacion(dateFormato.parse(dateFormato.format(fechaReprogramacion)));
        nuevoVuelos.setEstado(estado);

        // Aquí puedes llamar a tu servicio de AvionDao y utilizar el método agregarAvion() para insertar el nuevo avión en la base de datos
        vuelosdao.agregarVuelos(fechaSalida, horaSalida, fechaLlegada, horaLlegada, fechaReprogramacion, estado);

        // Obtener la lista de usuarios actualizada de la base de datos
        vuelos = vuelosdao.getAllVuelos();
        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }

    public void actualizarVuelos(int id, Date fechaSalida, Time horaSalida, Date fechaLlegada, Time horaLlegada, Date fechaReprogramacion, String estado) throws IOException, ParseException {
        Vuelos nuevoVuelo = new Vuelos();
        nuevoVuelo.setId(id);
        nuevoVuelo.setFechaSalida(dateFormato.parse(dateFormato.format(fechaSalida)));
        nuevoVuelo.setHoraSalida((Time) dateFormato.parse(dateFormato.format(horaSalida)));
        nuevoVuelo.setFechaLlegada(dateFormato.parse(dateFormato.format(fechaLlegada)));
        nuevoVuelo.setHoraLlegada((Time) dateFormato.parse(dateFormato.format(horaLlegada)));
        nuevoVuelo.setFechaReprogramacion(dateFormato.parse(dateFormato.format(fechaReprogramacion)));
        nuevoVuelo.setEstado(estado);

        vuelosdao.actualizarVuelos(id, fechaSalida, horaSalida, fechaLlegada, horaLlegada, fechaReprogramacion, estado);
        FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "comentarios actualizado correctamente", null));
    }

    public void eliminarVuelos(int idn, AjaxBehaviorEvent event) {
        VuelosDao serviceVuelos = new VuelosDao();
        serviceVuelos.eliminarVuelos(idn);
        //user.setId(idn);
        //usuarioService.eliminarUsuario(user);

        // Obtener la lista de usuarios actualizada de la base de datos
        vuelos = vuelosdao.getAllVuelos();
        FacesContext.getCurrentInstance().addMessage("formEliminar", new FacesMessage(FacesMessage.SEVERITY_INFO, "vuelos eliminado correctamente", null));
    }

}
