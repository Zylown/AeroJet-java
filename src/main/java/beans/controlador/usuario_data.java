package beans.controlador;

import bean.dao.UsuarioService;
import beans.modelo.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
//import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuario_data", eager = true)
@ViewScoped
public class usuario_data implements Serializable{
    
    private List<Usuario> usuarios;
    private UsuarioService usuarioService;
    private String nombreUsuario;
    private String password;
    private String email;
    private Usuario usuarioSeleccionado; // Nueva propiedad para almacenar el usuario seleccionado
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }
        
    public usuario_data() {
        usuarioService = new UsuarioService();
    }

    public List<Usuario> getUsuarios() {
        System.out.println(usuarios);
        return usuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
@PostConstruct
public void init() {
        usuarioService = new UsuarioService();
        usuarios = usuarioService.getAllUsuario();

        /*for (Usuario usuario : usuarios) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombreUsuario());
        System.out.println("Contraseña: " + usuario.getContraseña());
        System.out.println("Correo: " + usuario.getEmail());
        System.out.println("-----------------------");
    }*/
}



public void validarCuenta(String nombreUsuario, String contraseña) throws IOException {
    boolean cuentaValida = false;
    
    usuarioService = new UsuarioService();
    usuarios = usuarioService.getAllUsuario();
    
    for (Usuario usuario : usuarios) {
        if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
            cuentaValida = true;
            break;
        }
    }

    if (cuentaValida) {
        if (nombreUsuario.equals("admin") && contraseña.equals("pass")) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/AeroJet-Java/faces/resources/pages/vista-administrador/indexadmin.xhtml");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/AeroJet-Java/faces/index.xhtml");
        }
        FacesContext.getCurrentInstance().responseComplete();
    } else {
        FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecta", null));
    }
}

public void registrar(String nombreUsuario, String contraseña, String email) throws IOException {
    Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setNombreUsuario(nombreUsuario);
    nuevoUsuario.setContraseña(contraseña);
    nuevoUsuario.setEmail(email);
    
    // Aquí puedes llamar a tu servicio de UsuarioService y utilizar un método para insertar el nuevo usuario en la base de datos
    usuarioService.insertarUsuario(nombreUsuario, contraseña, email);
    
    // Otras acciones después del registro, como mostrar un mensaje de éxito o redirigir a otra página
    FacesContext.getCurrentInstance().addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", null));
    // Redirigir a otra página
    // FacesContext.getCurrentInstance().getExternalContext().redirect("otra_pagina.xhtml");
}

public void actualizarUsuario(int id, String nombreUsuario, String contraseña, String email) throws IOException {
     Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setId(id);
    nuevoUsuario.setNombreUsuario(nombreUsuario);
    nuevoUsuario.setContraseña(contraseña);
    nuevoUsuario.setEmail(email);
     
    usuarioService.actualizarUsuario(id, nombreUsuario, contraseña, email);
    FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario actualizado correctamente", null));
}


public void eliminarUsuario(int id) {
    usuarioService.eliminarUsuario(id);
    FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado correctamente", null));
}


/*
public void validarCuentaConsola() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Ingrese el nombre de usuario: ");
    String nombreUsuario = scanner.nextLine();
    System.out.print("Ingrese la contraseña: ");
    String contraseña = scanner.nextLine();
    
    validarCuenta(nombreUsuario, contraseña);
}*/
    

}
