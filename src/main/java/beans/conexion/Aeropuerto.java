/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.conexion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Unknown
 */
@Entity
@Table(name = "aeropuerto")
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a"),
    @NamedQuery(name = "Aeropuerto.findById", query = "SELECT a FROM Aeropuerto a WHERE a.id = :id"),
    @NamedQuery(name = "Aeropuerto.findByNombre", query = "SELECT a FROM Aeropuerto a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aeropuerto.findByCiudad", query = "SELECT a FROM Aeropuerto a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Aeropuerto.findByPais", query = "SELECT a FROM Aeropuerto a WHERE a.pais = :pais"),
    @NamedQuery(name = "Aeropuerto.findByCodigoIATA", query = "SELECT a FROM Aeropuerto a WHERE a.codigoIATA = :codigoIATA"),
    @NamedQuery(name = "Aeropuerto.findByCodigoICAO", query = "SELECT a FROM Aeropuerto a WHERE a.codigoICAO = :codigoICAO"),
    @NamedQuery(name = "Aeropuerto.findByLatitud", query = "SELECT a FROM Aeropuerto a WHERE a.latitud = :latitud"),
    @NamedQuery(name = "Aeropuerto.findByLongitud", query = "SELECT a FROM Aeropuerto a WHERE a.longitud = :longitud"),
    @NamedQuery(name = "Aeropuerto.findByZonaHoraria", query = "SELECT a FROM Aeropuerto a WHERE a.zonaHoraria = :zonaHoraria"),
    @NamedQuery(name = "Aeropuerto.findByTipoAeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.tipoAeropuerto = :tipoAeropuerto"),
    @NamedQuery(name = "Aeropuerto.findByTerminal", query = "SELECT a FROM Aeropuerto a WHERE a.terminal = :terminal"),
    @NamedQuery(name = "Aeropuerto.findByCapacidad", query = "SELECT a FROM Aeropuerto a WHERE a.capacidad = :capacidad")})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "Ciudad")
    private String ciudad;
    @Size(max = 100)
    @Column(name = "Pais")
    private String pais;
    @Size(max = 3)
    @Column(name = "CodigoIATA")
    private String codigoIATA;
    @Size(max = 4)
    @Column(name = "CodigoICAO")
    private String codigoICAO;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Latitud")
    private BigDecimal latitud;
    @Column(name = "Longitud")
    private BigDecimal longitud;
    @Size(max = 50)
    @Column(name = "ZonaHoraria")
    private String zonaHoraria;
    @Size(max = 50)
    @Column(name = "TipoAeropuerto")
    private String tipoAeropuerto;
    @Size(max = 50)
    @Column(name = "Terminal")
    private String terminal;
    @Column(name = "Capacidad")
    private Integer capacidad;
    @OneToMany(mappedBy = "aeropuertoDestinoID")
    private Collection<Rutas> rutasCollection;
    @OneToMany(mappedBy = "aeropuertoOrigenID")
    private Collection<Rutas> rutasCollection1;
    
    public Aeropuerto(Integer id, String nombre, String ciudad, String pais, String codigoIATA, String codigoICAO, String latitud, String longitud, String zonaHoraria, String tipoAeropuerto, String terminal, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoIATA = codigoIATA;
        this.codigoICAO = codigoICAO;
        this.latitud = new BigDecimal(latitud);
        this.longitud = new BigDecimal(longitud);
        this.zonaHoraria = zonaHoraria;
        this.tipoAeropuerto = tipoAeropuerto;
        this.terminal = terminal;
        this.capacidad = capacidad;
    }

    public Aeropuerto() {
    }

    public Aeropuerto(Integer id) {
        this.id = id;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Collection<Rutas> getRutasCollection() {
        return rutasCollection;
    }

    public void setRutasCollection(Collection<Rutas> rutasCollection) {
        this.rutasCollection = rutasCollection;
    }

    public Collection<Rutas> getRutasCollection1() {
        return rutasCollection1;
    }

    public void setRutasCollection1(Collection<Rutas> rutasCollection1) {
        this.rutasCollection1 = rutasCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Aeropuerto[ id=" + id + " ]";
    }
    
}
