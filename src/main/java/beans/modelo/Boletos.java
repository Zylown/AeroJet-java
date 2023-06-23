/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Unknown
 */
@Entity
@Table(name = "boletos")
@NamedQueries({
    @NamedQuery(name = "Boletos.findAll", query = "SELECT b FROM Boletos b"),
    @NamedQuery(name = "Boletos.findById", query = "SELECT b FROM Boletos b WHERE b.id = :id"),
    @NamedQuery(name = "Boletos.findByNumeroBoleto", query = "SELECT b FROM Boletos b WHERE b.numeroBoleto = :numeroBoleto"),
    @NamedQuery(name = "Boletos.findByPrecio", query = "SELECT b FROM Boletos b WHERE b.precio = :precio"),
    @NamedQuery(name = "Boletos.findByClase", query = "SELECT b FROM Boletos b WHERE b.clase = :clase"),
    @NamedQuery(name = "Boletos.findByFechaEmision", query = "SELECT b FROM Boletos b WHERE b.fechaEmision = :fechaEmision")})
public class Boletos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NumeroBoleto")
    private String numeroBoleto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Clase")
    private String clase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @OneToMany(mappedBy = "iDboleto")
    private Collection<Compras> comprasCollection;
    @JoinColumn(name = "Asiento_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Asientos asientoID;
    @JoinColumn(name = "Tarifa_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tarifas tarifaID;
    @JoinColumn(name = "Vuelo_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Vuelos vueloID;

    public Boletos() {
    }

    public Boletos(Integer id) {
        this.id = id;
    }

    public Boletos(Integer id, String numeroBoleto, BigDecimal precio, String clase, Date fechaEmision) {
        this.id = id;
        this.numeroBoleto = numeroBoleto;
        this.precio = precio;
        this.clase = clase;
        this.fechaEmision = fechaEmision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    public Asientos getAsientoID() {
        return asientoID;
    }

    public void setAsientoID(Asientos asientoID) {
        this.asientoID = asientoID;
    }

    public Tarifas getTarifaID() {
        return tarifaID;
    }

    public void setTarifaID(Tarifas tarifaID) {
        this.tarifaID = tarifaID;
    }

    public Vuelos getVueloID() {
        return vueloID;
    }

    public void setVueloID(Vuelos vueloID) {
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
        if (!(object instanceof Boletos)) {
            return false;
        }
        Boletos other = (Boletos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Boletos[ id=" + id + " ]";
    }
    
}
