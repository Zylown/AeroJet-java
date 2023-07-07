/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.controlador;

import bean.dao.ClienteService;
import beans.modelo.Cliente;
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

@ManagedBean(name = "cliente_data", eager = true)
@ViewScoped
public class cliente_data implements Serializable {
    private SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
    
    private List<Cliente> clientes;
    private ClienteService clienteService;
    private Cliente ClienteSeleccionado;
    
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private String genero;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String correo;

    public SimpleDateFormat getDateFormato() {
        return dateFormato;
    }

    public void setDateFormato(SimpleDateFormat dateFormato) {
        this.dateFormato = dateFormato;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente getClienteSeleccionado() {
        return ClienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente ClienteSeleccionado) {
        this.ClienteSeleccionado = ClienteSeleccionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @PostConstruct
    public void init() {
        clienteService = new ClienteService();
        clientes = clienteService.getAllClientes();
    }
    
    public void registrarr(String nombre, String apellido, int dni, int telefono, String genero, Date fechaNacimiento, String nacionalidad, String correoElectronico) throws IOException, ParseException {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setDni(dni);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setGenero(genero);
        nuevoCliente.setFechaNacimiento(dateFormato.parse(dateFormato.format(fechaNacimiento)));
        nuevoCliente.setNacionalidad(nacionalidad);
        nuevoCliente.setCorreoElectronico(correoElectronico);
        
        
        // Aquí puedes llamar a tu servicio de ClienteService y utilizar un método para insertar el nuevo cliente en la base de datos
        clienteService.insertarCliente(nombre, apellido, dni, telefono, genero, fechaNacimiento, nacionalidad, correoElectronico);
        // Obtener la lista de clientes actualizada de la base de datos
        clientes = clienteService.getAllClientes();
        // Restablecer los campos del formulario
        //descripcion = "";
        
        // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
        // Redirigir a otra página
        // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
    }  
    
}
