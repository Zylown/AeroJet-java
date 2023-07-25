package beans.controlador;

import bean.dao.boletoService;
import beans.modelo.Boletos;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "boleto_data", eager = true)
@ViewScoped
public class boleto_data {

    private List<Boletos> boletos;
    private boletoService boletoServices;

    private int id;
    private String tipo_vuelo;
    private String numero_vuelo;
    private BigDecimal precio;
    private String clase;
    private Date fecha_emision;

    private Boletos boletoSeleccionado; // Para almacenar el boleto seleccionado

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_vuelo() {
        return tipo_vuelo;
    }

    public void setTipo_vuelo(String tipo_vuelo) {
        this.tipo_vuelo = tipo_vuelo;
    }

    public String getNumero_vuelo() {
        return numero_vuelo;
    }

    public void setNumero_vuelo(String numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    
    // Getter para el boleto seleccionado
    public Boletos getBoletoSeleccionado() {
        return boletoSeleccionado;
    }

    @PostConstruct
    public void init() {
        boletoServices = new boletoService();
        boletos = boletoServices.getAllBoletos();
        
        // Supongamos que tienes el ID del boleto en la variable "idBoleto"
        int idBoleto = 123; // Reemplaza esto con el ID del boleto que deseas mostrar
        boletoSeleccionado = boletoServices.getBoletoById(idBoleto);
    }

}
