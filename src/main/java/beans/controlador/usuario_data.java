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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "usuario_data", eager = true)
@ViewScoped
public class usuario_data implements Serializable {

    private List<Usuario> usuarios;
    private Usuario user;
    private UsuarioService usuarioService;
    private String nombreUsuario;
    private String password;
    private String email;
    private Usuario usuarioSeleccionado; // Nueva propiedad para almacenar el usuario seleccionado
    private int id;
    private boolean terminosAceptados; // Nueva propiedad para almacenar el estado de aceptación de los términos

    public boolean isTerminosAceptados() {
        return terminosAceptados;
    }

    public void setTerminosAceptados(boolean terminosAceptados) {
        this.terminosAceptados = terminosAceptados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
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

    public void validarEmail(FacesContext context, UIComponent component, Object value) {
        String email = (String) value;
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!email.matches(emailPattern)) { //.matches es un metodo String para verificar el  texto(email) coincide con el patron(emailpattern)
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo electrónico no es válido", null);
            throw new ValidatorException(message);
        }
    }

    public void validarPassword(FacesContext context, UIComponent component, Object value) {
        String password = (String) value;

        if (password.length() <= 8) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña debe tener más de 8 caracteres", null);
            throw new ValidatorException(message);
        }
    }

    public void validarUsuario(FacesContext context, UIComponent component, Object value) {
        String usuario = (String) value;
        String pattern = "^[a-zA-Z0-9]+$";
        if (!usuario.matches(pattern) || usuario.length() <= 5) { //Se verifica si el usuario no coincide con el patrón 
            //Es con OR || porque si una funciona y la otra no, entonces no entra, si fuera && seria si solo si las dos funcionan
            //si una no entra, salta error, lo cual esta bien que sean independientes
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario contiene caracteres inválidos o tiene menos de 6 caracteres", null);
            throw new ValidatorException(message);
        }
    }

    public void registrar(String nombreUsuario, String contraseña, String email) throws IOException {
        if (!terminosAceptados) { // es igual a: terminosAceptados == false 
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe aceptar los términos y condiciones", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return; // Detener el registro si los términos no están aceptados
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setEmail(email);

        // Aquí puedes llamar a tu servicio de UsuarioService y utilizar un método para insertar el nuevo usuario en la base de datos
        usuarioService.insertarUsuario(nombreUsuario, contraseña, email);

        // Obtener la lista de usuarios actualizada de la base de datos
        usuarios = usuarioService.getAllUsuario();

        // Restablecer los campos del formulario
        nombreUsuario = "";
        contraseña = "";
        email = "";
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

    public void eliminarUsuario(int idn, AjaxBehaviorEvent event) {
        UsuarioService serviceUser = new UsuarioService();
        serviceUser.eliminarUsuario(idn);
        //user.setId(idn);
        //usuarioService.eliminarUsuario(user);

        // Obtener la lista de usuarios actualizada de la base de datos
        usuarios = usuarioService.getAllUsuario();

        //FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado correctamente", null));
        // Otras acciones después de la eliminación, como mostrar un mensaje de éxito
        FacesContext.getCurrentInstance().addMessage("formListado", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado exitosamente", null));

    }
}
