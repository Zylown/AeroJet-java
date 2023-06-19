/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.conexion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Unknown
 */
@Entity
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findById", query = "SELECT c FROM Compras c WHERE c.id = :id"),
    @NamedQuery(name = "Compras.findByFechaCompra", query = "SELECT c FROM Compras c WHERE c.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "Compras.findByTotalCompra", query = "SELECT c FROM Compras c WHERE c.totalCompra = :totalCompra"),
    @NamedQuery(name = "Compras.findByNumComfirmacion", query = "SELECT c FROM Compras c WHERE c.numComfirmacion = :numComfirmacion")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalCompra")
    private long totalCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NumComfirmacion")
    private String numComfirmacion;
    @OneToMany(mappedBy = "compraID")
    private Collection<Tarifas> tarifasCollection;
    @JoinColumn(name = "Asiento_ID", referencedColumnName = "ID")
    @ManyToOne
    private Asientos asientoID;
    @JoinColumn(name = "ID_boleto", referencedColumnName = "ID")
    @ManyToOne
    private Boletos iDboleto;
    @JoinColumn(name = "Usuario_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cliente usuarioID;
    @JoinColumn(name = "Tarifa_ID", referencedColumnName = "ID")
    @ManyToOne
    private Tarifas tarifaID;
    @JoinColumn(name = "TipoPago_ID", referencedColumnName = "ID")
    @ManyToOne
    private TipoPago tipoPagoID;
    @JoinColumn(name = "Vuelo_ID", referencedColumnName = "ID")
    @ManyToOne
    private Vuelos vueloID;
    @OneToMany(mappedBy = "compraID")
    private Collection<Vuelos> vuelosCollection;

    public Compras() {
    }

    public Compras(Integer id) {
        this.id = id;
    }

    public Compras(Integer id, Date fechaCompra, long totalCompra, String numComfirmacion) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
        this.numComfirmacion = numComfirmacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public long getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(long totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getNumComfirmacion() {
        return numComfirmacion;
    }

    public void setNumComfirmacion(String numComfirmacion) {
        this.numComfirmacion = numComfirmacion;
    }

    public Collection<Tarifas> getTarifasCollection() {
        return tarifasCollection;
    }

    public void setTarifasCollection(Collection<Tarifas> tarifasCollection) {
        this.tarifasCollection = tarifasCollection;
    }

    public Asientos getAsientoID() {
        return asientoID;
    }

    public void setAsientoID(Asientos asientoID) {
        this.asientoID = asientoID;
    }

    public Boletos getIDboleto() {
        return iDboleto;
    }

    public void setIDboleto(Boletos iDboleto) {
        this.iDboleto = iDboleto;
    }

    public Cliente getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Cliente usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Tarifas getTarifaID() {
        return tarifaID;
    }

    public void setTarifaID(Tarifas tarifaID) {
        this.tarifaID = tarifaID;
    }

    public TipoPago getTipoPagoID() {
        return tipoPagoID;
    }

    public void setTipoPagoID(TipoPago tipoPagoID) {
        this.tipoPagoID = tipoPagoID;
    }

    public Vuelos getVueloID() {
        return vueloID;
    }

    public void setVueloID(Vuelos vueloID) {
        this.vueloID = vueloID;
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
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Compras[ id=" + id + " ]";
    }
    
}
