/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Unknown
 */
@Entity
@Table(name = "vuelos")
@NamedQueries({
    @NamedQuery(name = "Vuelos.findAll", query = "SELECT v FROM Vuelos v"),
    @NamedQuery(name = "Vuelos.findById", query = "SELECT v FROM Vuelos v WHERE v.id = :id"),
    @NamedQuery(name = "Vuelos.findByFechaSalida", query = "SELECT v FROM Vuelos v WHERE v.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Vuelos.findByHoraSalida", query = "SELECT v FROM Vuelos v WHERE v.horaSalida = :horaSalida"),
    @NamedQuery(name = "Vuelos.findByFechaLlegada", query = "SELECT v FROM Vuelos v WHERE v.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "Vuelos.findByHoraLlegada", query = "SELECT v FROM Vuelos v WHERE v.horaLlegada = :horaLlegada"),
    @NamedQuery(name = "Vuelos.findByFechaReprogramacion", query = "SELECT v FROM Vuelos v WHERE v.fechaReprogramacion = :fechaReprogramacion"),
    @NamedQuery(name = "Vuelos.findByEstado", query = "SELECT v FROM Vuelos v WHERE v.estado = :estado")})
public class Vuelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Fecha_Salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "Hora_Salida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @Column(name = "Fecha_Llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column(name = "Hora_Llegada")
    @Temporal(TemporalType.TIME)
    private Date horaLlegada;
    @Column(name = "Fecha_Reprogramacion")
    @Temporal(TemporalType.DATE)
    private Date fechaReprogramacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vueloID")
    private Collection<Escalas> escalasCollection;
    @OneToMany(mappedBy = "vueloID")
    private Collection<Tarifas> tarifasCollection;
    @OneToMany(mappedBy = "vueloID")
    private Collection<Compras> comprasCollection;
    @OneToMany(mappedBy = "vueloID")
    private Collection<Asientos> asientosCollection;
    @JoinColumn(name = "Avion_ID", referencedColumnName = "ID")
    @ManyToOne
    private Aviones avionID;
    @JoinColumn(name = "Compra_ID", referencedColumnName = "ID")
    @ManyToOne
    private Compras compraID;
    @JoinColumn(name = "Ruta_ID", referencedColumnName = "ID")
    @ManyToOne
    private Rutas rutaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vueloID")
    private Collection<Boletos> boletosCollection;
    @OneToMany(mappedBy = "vueloID")
    private Collection<Comentarios> comentariosCollection;

    public Vuelos() {
    }

    public Vuelos(Integer id) {
        this.id = id;
    }

    public Vuelos(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getFechaReprogramacion() {
        return fechaReprogramacion;
    }

    public void setFechaReprogramacion(Date fechaReprogramacion) {
        this.fechaReprogramacion = fechaReprogramacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Escalas> getEscalasCollection() {
        return escalasCollection;
    }

    public void setEscalasCollection(Collection<Escalas> escalasCollection) {
        this.escalasCollection = escalasCollection;
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

    public Collection<Asientos> getAsientosCollection() {
        return asientosCollection;
    }

    public void setAsientosCollection(Collection<Asientos> asientosCollection) {
        this.asientosCollection = asientosCollection;
    }

    public Aviones getAvionID() {
        return avionID;
    }

    public void setAvionID(Aviones avionID) {
        this.avionID = avionID;
    }

    public Compras getCompraID() {
        return compraID;
    }

    public void setCompraID(Compras compraID) {
        this.compraID = compraID;
    }

    public Rutas getRutaID() {
        return rutaID;
    }

    public void setRutaID(Rutas rutaID) {
        this.rutaID = rutaID;
    }

    public Collection<Boletos> getBoletosCollection() {
        return boletosCollection;
    }

    public void setBoletosCollection(Collection<Boletos> boletosCollection) {
        this.boletosCollection = boletosCollection;
    }

    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
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
        if (!(object instanceof Vuelos)) {
            return false;
        }
        Vuelos other = (Vuelos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.conexion.Vuelos[ id=" + id + " ]";
    }
    
}
