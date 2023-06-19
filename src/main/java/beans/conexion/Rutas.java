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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rutas")
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r"),
    @NamedQuery(name = "Rutas.findById", query = "SELECT r FROM Rutas r WHERE r.id = :id"),
    @NamedQuery(name = "Rutas.findByPuntoOrigen", query = "SELECT r FROM Rutas r WHERE r.puntoOrigen = :puntoOrigen"),
    @NamedQuery(name = "Rutas.findByPuntoDestino", query = "SELECT r FROM Rutas r WHERE r.puntoDestino = :puntoDestino"),
    @NamedQuery(name = "Rutas.findByDistancia", query = "SELECT r FROM Rutas r WHERE r.distancia = :distancia"),
    @NamedQuery(name = "Rutas.findByDuracionEstimada", query = "SELECT r FROM Rutas r WHERE r.duracionEstimada = :duracionEstimada")})
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "PuntoOrigen")
    private String puntoOrigen;
    @Size(max = 50)
    @Column(name = "PuntoDestino")
    private String puntoDestino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Distancia")
    private BigDecimal distancia;
    @Column(name = "DuracionEstimada")
    private Integer duracionEstimada;
    @OneToMany(mappedBy = "rutaID")
    private Collection<Vuelos> vuelosCollection;
    @JoinColumn(name = "AeropuertoDestino_ID", referencedColumnName = "ID")
    @ManyToOne
    private Aeropuerto aeropuertoDestinoID;
    @JoinColumn(name = "AeropuertoOrigen_ID", referencedColumnName = "ID")
    @ManyToOne
    private Aeropuerto aeropuertoOrigenID;

    public Rutas() {
    }

    public Rutas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuntoOrigen() {
        return puntoOrigen;
    }

    public void setPuntoOrigen(String puntoOrigen) {
        this.puntoOrigen = puntoOrigen;
    }

    public String getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(String puntoDestino) {
        this.puntoDestino = puntoDestino;
    }

    public BigDecimal getDistancia() {
        return distancia;
    }

    public void setDistancia(BigDecimal distancia) {
        this.distancia = distancia;
    }

    public Integer getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(Integer duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public Collection<Vuelos> getVuelosCollection() {
        return vuelosCollection;
    }

    public void setVuelosCollection(Collection<Vuelos> vuelosCollection) {
        this.vuelosCollection = vuelosCollection;
    }

    public Aeropuerto getAeropuertoDestinoID() {
        return aeropuertoDestinoID;
    }

    public void setAeropuertoDestinoID(Aeropuerto aeropuertoDestinoID) {
        this.aeropuertoDestinoID = aeropuertoDestinoID;
    }

    public Aeropuerto getAeropuertoOrigenID() {
        return aeropuertoOrigenID;
    }

    public void setAeropuertoOrigenID(Aeropuerto aeropuertoOrigenID) {
        this.aeropuertoOrigenID = aeropuertoOrigenID;
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
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Rutas[ id=" + id + " ]";
    }
    
}
