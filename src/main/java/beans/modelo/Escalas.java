/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Unknown
 */
@Entity
@Table(name = "escalas")
@NamedQueries({
    @NamedQuery(name = "Escalas.findAll", query = "SELECT e FROM Escalas e"),
    @NamedQuery(name = "Escalas.findById", query = "SELECT e FROM Escalas e WHERE e.id = :id"),
    @NamedQuery(name = "Escalas.findByCiudad", query = "SELECT e FROM Escalas e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Escalas.findByDuracion", query = "SELECT e FROM Escalas e WHERE e.duracion = :duracion")})
public class Escalas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Duracion")
    private int duracion;
    @JoinColumn(name = "Vuelo_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private int vueloID;

    public Escalas(int vueloID) {
        this.vueloID = vueloID;
    }

    public Escalas(Integer id, String ciudad, int duracion, int vueloID) {
        this.id = id;
        this.ciudad = ciudad;
        this.duracion = duracion;
        this.vueloID = vueloID;
    }

    public Escalas() {
    }

    public Escalas(Integer id) {
        this.id = id;
    }

    public Escalas(Integer id, String ciudad, int duracion) {
        this.id = id;
        this.ciudad = ciudad;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getVueloID() {
        return vueloID;
    }

    public void setVueloID(int vueloID) {
        this.vueloID = vueloID;
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
        if (!(object instanceof Escalas)) {
            return false;
        }
        Escalas other = (Escalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Escalas[ id=" + id + " ]";
    }
    
}
