/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "asientos")
@NamedQueries({
    @NamedQuery(name = "Asientos.findAll", query = "SELECT a FROM Asientos a"),
    @NamedQuery(name = "Asientos.findById", query = "SELECT a FROM Asientos a WHERE a.id = :id"),
    @NamedQuery(name = "Asientos.findByNumero", query = "SELECT a FROM Asientos a WHERE a.numero = :numero"),
    @NamedQuery(name = "Asientos.findByEstado", query = "SELECT a FROM Asientos a WHERE a.estado = :estado"),
    @NamedQuery(name = "Asientos.findByUbicacion", query = "SELECT a FROM Asientos a WHERE a.ubicacion = :ubicacion")})
public class Asientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Numero")
    private Integer numero;
    @Column(name = "Estado")
    private Boolean estado;
    @Size(max = 70)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @OneToMany(mappedBy = "asientoID")
    private Collection<Tarifas> tarifasCollection;
    @OneToMany(mappedBy = "asientoID")
    private Collection<Compras> comprasCollection;
    @JoinColumn(name = "Avion_ID", referencedColumnName = "ID")
    @ManyToOne
    private Aviones avionID;
    @JoinColumn(name = "Vuelo_ID", referencedColumnName = "ID")
    @ManyToOne
    private Vuelos vueloID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asientoID")
    private Collection<Boletos> boletosCollection;

    public Asientos() {
    }

    public Asientos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Collection<Tarifas> getTarifasCollection() {
        return tarifasCollection;
    }

    public void setTarifasCollection(Collection<Tarifas> tarifasCollection) {
        this.tarifasCollection = tarifasCollection;
    }

    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    public Aviones getAvionID() {
        return avionID;
    }

    public void setAvionID(Aviones avionID) {
        this.avionID = avionID;
    }

    public Vuelos getVueloID() {
        return vueloID;
    }

    public void setVueloID(Vuelos vueloID) {
        this.vueloID = vueloID;
    }

    public Collection<Boletos> getBoletosCollection() {
        return boletosCollection;
    }

    public void setBoletosCollection(Collection<Boletos> boletosCollection) {
        this.boletosCollection = boletosCollection;
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
        if (!(object instanceof Asientos)) {
            return false;
        }
        Asientos other = (Asientos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Asientos[ id=" + id + " ]";
    }
    
}
