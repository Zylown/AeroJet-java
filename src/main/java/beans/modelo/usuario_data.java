package beans.modelo;

import Servicios.UsuarioService;
import beans.conexion.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
//import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuario_data")
@ViewScoped
public class usuario_data implements Serializable{
    
    private List<Usuario> usuarios;
    private UsuarioService usuarioService;
    private String nombreUsuario;
    private String password;
    
    public usuario_data() {
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

/*
public void validarCuentaConsola() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Ingrese el nombre de usuario: ");
    String nombreUsuario = scanner.nextLine();
    System.out.print("Ingrese la contraseña: ");
    String contraseña = scanner.nextLine();
    
    validarCuenta(nombreUsuario, contraseña);
}*/
    
@PostConstruct
public void init() {
        usuarioService = new UsuarioService();
        usuarios = usuarioService.getAllUsuario();
        
        for (Usuario usuario : usuarios) {
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombreUsuario());
        System.out.println("Ciudad: " + usuario.getContraseña());
        System.out.println("-----------------------");
    }
}
}
