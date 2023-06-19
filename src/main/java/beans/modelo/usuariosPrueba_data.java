package beans.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import beans.conexion.usuariosPrueba;

@ManagedBean(name = "usuarios_data")
@RequestScoped
public class usuariosPrueba_data {
    
     public List<usuariosPrueba> ListadoUsuarios;
     
     public List<usuariosPrueba> getListadoUsuarios(){
         ListadoUsuarios = new ArrayList<>();
         ListadoUsuarios.add(new usuariosPrueba("Sevastian","sevastian@gmail.com","1234"));
         ListadoUsuarios.add(new usuariosPrueba("Pepe","pepe@gmail.com","4321"));
         return ListadoUsuarios;
     }
}
