package beans.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "usuarios_data")
@RequestScoped
public class usuarios_data {
    
     public List<usuarios> ListadoUsuarios;
     
     public List<usuarios> getListadoUsuarios(){
         ListadoUsuarios = new ArrayList<>();
         ListadoUsuarios.add(new usuarios("Sevastian","sevastian@gmail.com","1234"));
         ListadoUsuarios.add(new usuarios("Pepe","pepe@gmail.com","4321"));
         return ListadoUsuarios;
     }
}
