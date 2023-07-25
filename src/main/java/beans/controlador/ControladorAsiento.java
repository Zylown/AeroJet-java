package beans.controlador;

import bean.dao.AsientosDao;
import beans.modelo.Asientos;
import beans.modelo.Aviones;
import beans.modelo.Vuelos;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "controlador_asiento", eager = true)
@ViewScoped
public class ControladorAsiento implements Serializable {

    private static final long serialVersionUID = 123456789L;
    private List<Asientos> asientos;
    private AsientosDao asientosDao;
     // Lista para almacenar los asientos seleccionados
    private Asientos asientoseleccionado;
    private int indiceAsientoSeleccionado;
    private int id;
    private Aviones avionid;
    private Vuelos vueloid;
    private int nuemero;
    private boolean estado;
    private String ubicacion;

    @PostConstruct
    public void init() {
        asientosDao = new AsientosDao();
        asientos = asientosDao.getAllAsientos();
        Collections.sort(asientos, (a1, a2) -> Integer.compare(a1.getNumero(), a2.getNumero()));
        
        // Inicializamos la lista de asientos seleccionados
       
    }

    public int getIndiceAsientoSeleccionado() {
        return indiceAsientoSeleccionado;
    }

    public void setIndiceAsientoSeleccionado(int indiceAsientoSeleccionado) {
        this.indiceAsientoSeleccionado = indiceAsientoSeleccionado;
    }

    public AsientosDao getAsientosDao() {
        return asientosDao;
    }

    public void setAsientosDao(AsientosDao asientosDao) {
        this.asientosDao = asientosDao;
    }

    public Asientos getAsientoseleccionado() {
        return asientoseleccionado;
    }

    public void setAsientoseleccionado(Asientos asientoseleccionado) {
        this.asientoseleccionado = asientoseleccionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviones getAvionid() {
        return avionid;
    }

    public void setAvionid(Aviones avionid) {
        this.avionid = avionid;
    }

    public Vuelos getVueloid() {
        return vueloid;
    }

    public void setVueloid(Vuelos vueloid) {
        this.vueloid = vueloid;
    }

    public int getNuemero() {
        return nuemero;
    }

    public void setNuemero(int nuemero) {
        this.nuemero = nuemero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Asientos> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asientos> asientos) {
        this.asientos = asientos;
    }

    

 public void toggleAsiento(Asientos asiento) {
    System.out.println("Toggle asiento: " + asiento.getNumero());

    if (!asiento.isEstado()) {
        // Si el asiento ya está en estado "false" (comprado), no permitir cambiar el estado
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                "El asiento ya ha sido comprado y no puede cambiar su estado.", null));
        return;
    }

    // Lógica para cambiar el estado del asiento en la base de datos utilizando el DAO
    try {
        // Si hay un asiento seleccionado previamente, lo cambiamos a estado "false"
        if (asientoseleccionado != null) {
            asientoseleccionado.setEstado(true);
            asientosDao.actualizarAsiento(asientoseleccionado);
        }

        asiento.setEstado(!asiento.isEstado());
        asientosDao.actualizarAsiento(asiento); // Llama al método en el DAO para actualizar el estado del asiento

        // Actualizamos el asiento seleccionado con el nuevo asiento
        asientoseleccionado = asiento;
    } catch (Exception e) {
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error al actualizar el asiento en la base de datos: " + e.getMessage(), null));
    }
}




    public void confirmarCompra() throws IOException {
        // Aquí puedes agregar el código para procesar la confirmación de la compra
 if (asientoseleccionado == null) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debes seleccionar un asiento antes de confirmar la compra.", null));
        return;
    }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra confirmada", null));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/AeroJet-Java/faces/resources/pages/buscar-vuelo/formPasajeros/formPasajero.xhtml");
    }
    
}