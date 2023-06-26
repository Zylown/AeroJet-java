/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.modelo;

import java.io.Serializable;
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
@Table(name = "aviones")
@NamedQueries({
    @NamedQuery(name = "Aviones.findAll", query = "SELECT a FROM Aviones a"),
    @NamedQuery(name = "Aviones.findById", query = "SELECT a FROM Aviones a WHERE a.id = :id"),
    @NamedQuery(name = "Aviones.findByModelo", query = "SELECT a FROM Aviones a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Aviones.findByCapacidad", query = "SELECT a FROM Aviones a WHERE a.capacidad = :capacidad"),
    @NamedQuery(name = "Aviones.findByEstado", query = "SELECT a FROM Aviones a WHERE a.estado = :estado")})
public class Aviones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Modelo")
    private String modelo;
    @Column(name = "Capacidad")
    private Integer capacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(mappedBy = "avionID")
    private Collection<Asientos> asientosCollection;
    @OneToMany(mappedBy = "avionID")
    private Collection<Vuelos> vuelosCollection;

    public Aviones() {
    }
    
    public Aviones(Integer id, String modelo, Integer capacidad, String estado) {
        this.id = id;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Aviones(Integer id) {
        this.id = id;
    }

    public Aviones(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Asientos> getAsientosCollection() {
        return asientosCollection;
    }

    public void setAsientosCollection(Collection<Asientos> asientosCollection) {
        this.asientosCollection = asientosCollection;
    }

    public Collection<Vuelos> getVuelosCollection() {
        return vuelosCollection;
    }

    public void setVuelosCollection(Collection<Vuelos> vuelosCollection) {
        this.vuelosCollection = vuelosCollection;
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
        if (!(object instanceof Aviones)) {
            return false;
        }
        Aviones other = (Aviones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Aviones[ id=" + id + " ]";
    }
    
}
