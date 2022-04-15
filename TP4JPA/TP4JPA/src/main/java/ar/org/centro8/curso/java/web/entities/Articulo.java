/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.web.entities;

import ar.org.centro8.curso.java.web.enums.EspecieRecomendada;
import ar.org.centro8.curso.java.web.enums.Tipo;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findById", query = "SELECT a FROM Articulo a WHERE a.id = :id"),
    @NamedQuery(name = "Articulo.findByNombre", query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Articulo.findByTipo", query = "SELECT a FROM Articulo a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Articulo.findByEspecieRecomendada", query = "SELECT a FROM Articulo a WHERE a.especieRecomendada = :especieRecomendada"),
    @NamedQuery(name = "Articulo.findByCosto", query = "SELECT a FROM Articulo a WHERE a.costo = :costo"),
    @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio"),
    @NamedQuery(name = "Articulo.findByStock", query = "SELECT a FROM Articulo a WHERE a.stock = :stock"),
    @NamedQuery(name = "Articulo.findByStockMinimo", query = "SELECT a FROM Articulo a WHERE a.stockMinimo = :stockMinimo"),
    @NamedQuery(name = "Articulo.findByStockMaximo", query = "SELECT a FROM Articulo a WHERE a.stockMaximo = :stockMaximo"),
    @NamedQuery(name = "Articulo.findByComentarios", query = "SELECT a FROM Articulo a WHERE a.comentarios = :comentarios"),
    @NamedQuery(name = "Articulo.findByActivo", query = "SELECT a FROM Articulo a WHERE a.activo = :activo")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 11)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "especieRecomendada")
    private String especieRecomendada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockMinimo")
    private int stockMinimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stockMaximo")
    private int stockMaximo;
    @Size(max = 255)
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "activo")
    private Boolean activo;

    public Articulo() {
        
    }

    public Articulo(String nombre, String descripcion, String tipo, String especieRecomendada, double costo, double precio, int stock, int stockMinimo, int stockMaximo, String comentarios, Boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.especieRecomendada = especieRecomendada;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.comentarios = comentarios;
        this.activo = activo;
    }

    public Articulo(Integer id, String nombre, String descripcion, String tipo, String especieRecomendada, double costo, double precio, int stock, int stockMinimo, int stockMaximo, String comentarios, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.especieRecomendada = especieRecomendada;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.comentarios = comentarios;
        this.activo = activo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecieRecomendada() {
        return especieRecomendada;
    }

    public void setEspecieRecomendada(String especieRecomendada) {
        this.especieRecomendada = especieRecomendada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", especieRecomendada=" + especieRecomendada + ", costo=" + costo + ", precio=" + precio + ", stock=" + stock + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", comentarios=" + comentarios + ", activo=" + activo + '}';
    }

    
}
