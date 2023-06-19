package beans.conexion;

import java.math.BigDecimal;

public class aeropuertoPrueba {
    private Integer id;
    private String nombre;
    private String ciudad;
    private String pais;
    private String codigoIATA;
    private String codigoICAO;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String zonaHoraria;
    private String tipoAeropuerto;
    private String terminal;
    private String capacidad;

    public aeropuertoPrueba(int id, String nombre, String ciudad, String pais, String codigoIATA, String codigoICAO, String zonaHoraria, String tipoAeropuerto, String terminal, String gmT5, String aeropuerto_Civiles, String capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoIATA = codigoIATA;
        this.codigoICAO = codigoICAO;
        this.latitud = latitud;
        this.longitud = longitud;
        this.zonaHoraria = zonaHoraria;
        this.tipoAeropuerto = tipoAeropuerto;
        this.terminal = terminal;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getCodigoICAO() {
        return codigoICAO;
    }

    public void setCodigoICAO(String codigoICAO) {
        this.codigoICAO = codigoICAO;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public String getTipoAeropuerto() {
        return tipoAeropuerto;
    }

    public void setTipoAeropuerto(String tipoAeropuerto) {
        this.tipoAeropuerto = tipoAeropuerto;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
}
