package beans.controlador;

import bean.dao.TarifasService;
import beans.modelo.Tarifas;
import beans.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tarifas_data", eager = true)
@ViewScoped

public class tarifas_data implements Serializable {
    private SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
    
    private List<Tarifas> tarifas;
    private TarifasService tarifaService;
    private Tarifas TarifaSeleccionado; // Nueva propiedad para almacenar el usuario seleccionado
    
    private String descripcion;
    private int id;
    private String precio;
    private Boolean promocion;
    private Date fechaInicio;
    private Date fechaFin;
    private String CargoAdicional;
            

    public List<Tarifas> getTarifas() {
        return tarifas;
    }

    public void setTarifas(List<Tarifas> tarifas) {
        this.tarifas = tarifas;
    }

    public TarifasService getTarifaService() {
        return tarifaService;
    }

    public void setTarifaService(TarifasService tarifaService) {
        this.tarifaService = tarifaService;
    }

    public Tarifas getTarifaSeleccionado() {
        return TarifaSeleccionado;
    }

    public void setTarifaSeleccionado(Tarifas TarifaSeleccionado) {
        this.TarifaSeleccionado = TarifaSeleccionado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Boolean getPromocion() {
        return promocion;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCargoAdicional() {
        return CargoAdicional;
    }

    public void setCargoAdicional(String CargoAdicional) {
        this.CargoAdicional = CargoAdicional;
    } 
    
    @PostConstruct
    public void init() {
        tarifaService = new TarifasService();
        tarifas = tarifaService.getAllTarifas();
    }

    public void registrar(BigDecimal precio, String descripcion, Date fechaInicio, Date fechaFin,Boolean promocion,BigDecimal montoCargoAdicional) throws IOException, ParseException {
        Tarifas nuevoTarifa = new Tarifas();
        nuevoTarifa.setPrecio(precio);
        nuevoTarifa.setDescripcion(descripcion);
        nuevoTarifa.setFechaInicio(dateFormato.parse(dateFormato.format(fechaInicio)));
        nuevoTarifa.setFechaFin(dateFormato.parse(dateFormato.format(fechaFin)));
        nuevoTarifa.setPromocion(promocion);
        nuevoTarifa.setMontoCargoAdicional(montoCargoAdicional);

        // Aquí puedes llamar a tu servicio de UsuarioService y utilizar un método para insertar el nuevo usuario en la base de datos
        tarifaService.insertarTarifa(precio, descripcion, fechaInicio, fechaFin,promocion,montoCargoAdicional);

        // Obtener la lista de usuarios actualizada de la base de datos
        tarifas = tarifaService.getAllTarifas();
        
        // Restablecer los campos del formulario
        //descripcion = "";
        
        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }    
        
public void registrarConsola() throws IOException, ParseException {
    try {
        Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el precio: ");
    BigDecimal precio = scanner.nextBigDecimal();

    scanner.nextLine(); // Consumir la nueva línea pendiente después de nextBigDecimal()

    System.out.print("Ingrese la descripción: ");
    String descripcion = scanner.nextLine();

    System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
    String fechaInicioStr = scanner.nextLine();
    Date fechaInicio = dateFormato.parse(fechaInicioStr);

    System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
    String fechaFinStr = scanner.nextLine();
    Date fechaFin = dateFormato.parse(fechaFinStr);

    System.out.print("Ingrese la promoción (true/false): ");
    boolean promocion = scanner.nextBoolean();

    scanner.nextLine(); // Consumir la nueva línea pendiente después de nextBoolean()

    System.out.print("Ingrese el monto de cargo adicional: ");
    BigDecimal montoCargoAdicional = scanner.nextBigDecimal();

    //tarifaService.insertarTarifa(precio, descripcion, fechaInicio, fechaFin, promocion, montoCargoAdicional);
    registrar(precio, descripcion, fechaInicio, fechaFin, promocion, montoCargoAdicional);
    //scanner.close();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al insertar tarifas en la base de datos: " + e.getMessage());
    }
    
}
}
