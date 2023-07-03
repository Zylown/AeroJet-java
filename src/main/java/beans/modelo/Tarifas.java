package beans.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "tarifas")
@NamedQueries({
    @NamedQuery(name = "Tarifas.findAll", query = "SELECT t FROM Tarifas t"),
    @NamedQuery(name = "Tarifas.findById", query = "SELECT t FROM Tarifas t WHERE t.id = :id"),
    @NamedQuery(name = "Tarifas.findByPrecio", query = "SELECT t FROM Tarifas t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tarifas.findByPromocion", query = "SELECT t FROM Tarifas t WHERE t.promocion = :promocion"),
    @NamedQuery(name = "Tarifas.findByFechaInicio", query = "SELECT t FROM Tarifas t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Tarifas.findByFechaFin", query = "SELECT t FROM Tarifas t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "Tarifas.findByMontoCargoAdicional", query = "SELECT t FROM Tarifas t WHERE t.montoCargoAdicional = :montoCargoAdicional")})
public class Tarifas implements Serializable {

    @Lob
    @Size(max = 65535)
    @Column(name = "Descripcion")
    private String descripcion;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio")
    private BigDecimal precio;
    @Column(name = "Promocion")
    private Boolean promocion;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "MontoCargoAdicional")
    private BigDecimal montoCargoAdicional;
    @JoinColumn(name = "Asiento_ID", referencedColumnName = "ID")
    @ManyToOne
    private Asientos asientoID;
    @JoinColumn(name = "Compra_ID", referencedColumnName = "ID")
    @ManyToOne
    private Compras compraID;
    @JoinColumn(name = "Vuelo_ID", referencedColumnName = "ID")
    @ManyToOne
    private Vuelos vueloID;
    @OneToMany(mappedBy = "tarifaID")
    private Collection<Compras> comprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifaID")
    private Collection<Boletos> boletosCollection;

public Tarifas(String descripcion, Integer id, BigDecimal precio, Boolean promocion, Date fechaInicio, Date fechaFin, BigDecimal montoCargoAdicional) {
    this.descripcion = descripcion;
    this.id = id;
    this.precio = precio;
    this.promocion = promocion;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.montoCargoAdicional = montoCargoAdicional;
}



    public Tarifas() {
    }

    public Tarifas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Boolean getPromocion() {
        return promocion;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getMontoCargoAdicional() {
        return montoCargoAdicional;
    }

    public void setMontoCargoAdicional(BigDecimal montoCargoAdicional) {
        this.montoCargoAdicional = montoCargoAdicional;
    }

    public Asientos getAsientoID() {
        return asientoID;
    }

    public void setAsientoID(Asientos asientoID) {
        this.asientoID = asientoID;
    }

    public Compras getCompraID() {
        return compraID;
    }

    public void setCompraID(Compras compraID) {
        this.compraID = compraID;
    }

    public Vuelos getVueloID() {
        return vueloID;
    }

    public void setVueloID(Vuelos vueloID) {
        this.vueloID = vueloID;
    }

    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
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
        if (!(object instanceof Tarifas)) {
            return false;
        }
        Tarifas other = (Tarifas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Tarifas[ id=" + id + " ]";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
