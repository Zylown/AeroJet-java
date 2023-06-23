package beans.controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import bean.dao.AeropuertoService;
import beans.modelo.Aeropuerto;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@ManagedBean(name = "aeropuerto_data")
@ViewScoped
public class aeropuerto_data implements Serializable{
    
    private List<Aeropuerto> aeropuertos;
    private AeropuertoService aeropuertoService;
     //private List<aeropuertoPrueba> aeropuertos;
    //private AeropuertoService aeropuertoService;

    /*@PostConstruct
    public void init() {
        aeropuertoService = new AeropuertoService();
        aeropuertos = aeropuertoService.getAllAeropuertos();
    }*/
     
    //public List<SelectItem> getListadoAeropuerto(){
        /*aeropuertos = new ArrayList<>();
        aeropuertos.add(new aeropuertoPrueba( 1, "Aeropuerto Internacional Jorge Chávez", "Lima", "Perú", "LIM", "SPJC", "-12.02301576740303", "-77.10801727581402", "GMT-5", "Aeropuerto Civiles", "Jorge Chavez", "10000000"));
        return aeropuertos;*/
        /*List<SelectItem> opciones = new ArrayList<>();
        opciones.add(new SelectItem(1, "Lima - Aeropuerto Internacional Jorge Chávez (LIM)"));
        opciones.add(new SelectItem(2, "Aeropuerto Internacional aeaa"));
        
        return opciones;
    }*/
    
    public aeropuerto_data() {
        
    }
    
    public String obtenerEtiquetaAeropuerto(Aeropuerto aeropuertos) {
        //Lima - Aeropuerto Internacional Jorge Chávez (LIM)
        //return aeropuertos.getNombre() + " (" + aeropuertos.getCiudad() + ")";
        return aeropuertos.getCiudad() + " - " + aeropuertos.getNombre() + " (" + aeropuertos.getCodigoIATA()+")";
    }

    public List<Aeropuerto> getAeropuertos() {
        System.out.println(aeropuertos);
        return aeropuertos;
    }

@PostConstruct
public void init() {
        aeropuertoService = new AeropuertoService();
        aeropuertos = aeropuertoService.getAllAeropuertos();
        
        for (Aeropuerto aeropuerto : aeropuertos) {
        System.out.println("ID: " + aeropuerto.getId());
        System.out.println("Nombre: " + aeropuerto.getNombre());
        System.out.println("Ciudad: " + aeropuerto.getCiudad());
        System.out.println("Pais: " + aeropuerto.getPais());
        System.out.println("Código IATA: " + aeropuerto.getCodigoIATA());
        System.out.println("Código ICAO: " + aeropuerto.getCodigoICAO());
        System.out.println("Latitud: " + aeropuerto.getLatitud());
        System.out.println("Longitud: " + aeropuerto.getLongitud());
        System.out.println("Zona Horaria: " + aeropuerto.getZonaHoraria());
        System.out.println("Tipo de Aeropuerto: " + aeropuerto.getTipoAeropuerto());
        System.out.println("Terminal: " + aeropuerto.getTerminal());
        System.out.println("Capacidad: " + aeropuerto.getCapacidad());
        System.out.println("-----------------------");
    }
}
     /*
public List<Aeropuerto> getListadoAeropuerto(){
        
    for (Aeropuerto aeropuerto : aeropuertos) {
        System.out.println("ID: " + aeropuerto.getId());
        System.out.println("Nombre: " + aeropuerto.getNombre());
        System.out.println("Ciudad: " + aeropuerto.getCiudad());
        System.out.println("Pais: " + aeropuerto.getPais());
        System.out.println("Código IATA: " + aeropuerto.getCodigoIATA());
        System.out.println("Código ICAO: " + aeropuerto.getCodigoICAO());
        System.out.println("Latitud: " + aeropuerto.getLatitud());
        System.out.println("Longitud: " + aeropuerto.getLongitud());
        System.out.println("Zona Horaria: " + aeropuerto.getZonaHoraria());
        System.out.println("Tipo de Aeropuerto: " + aeropuerto.getTipoAeropuerto());
        System.out.println("Terminal: " + aeropuerto.getTerminal());
        System.out.println("Capacidad: " + aeropuerto.getCapacidad());
        System.out.println("-----------------------");
    }
        
        return aeropuertoService.getAllAeropuertos();
        
    }*/
}
