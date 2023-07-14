package beans.controlador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "vuelos_data", eager = true)
@ViewScoped
public class vuelos_data implements Serializable{
   
   private Date fecha;
    
   public void onClick(Date fecha){
       SimpleDateFormat dateFormato = new SimpleDateFormat("dd/MM/YYYY");
       System.out.println(dateFormato.format(fecha));
   }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
}
