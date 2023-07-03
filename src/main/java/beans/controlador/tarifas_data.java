package beans.controlador;

import bean.dao.TarifasService;
import beans.modelo.Tarifas;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tarifas_data", eager = true)
@ViewScoped

public class tarifas_data implements Serializable {

    private List<Tarifas> tarifas;
    private TarifasService tarifaService;
   /* private String descripcion;
    private int id;
    private String precio;
    private Boolean promocion;
    private Date fechaInicio;
    private Date fechaFin;
    private String CargoAdicional;*/
            

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
    
    
    @PostConstruct
    public void init() {
        tarifaService = new TarifasService();
        tarifas = tarifaService.getAllTarifas();
    }

}
