/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Titione
 */
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "codigo",nullable = false)
    private String codigo;
    
    @Column (name = "nome",nullable = false)
    private String nome;
    
    @Column (name = "raca",nullable = false)
    private String raca;
    
    @Column (name = "nascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    
    @Column (name = "peso",nullable = false)
    private double peso;
    
    @Column (name = "sexo",nullable = false)
    private String sexo;
    
    @Column (name = "observacao",nullable = false)
    private String observacao;
    
    
    @ManyToOne
    @JoinColumn(name = "id_dono")
    private Dono dono;

    public Animal() {
    }

    public Animal(Long id, String codigo, String nome, String raca, Date nascimento, double peso, String sexo, String observacao) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.raca = raca;
        this.nascimento = nascimento;
        this.peso = peso;
        this.sexo = sexo;
        this.observacao = observacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.petshoperia.modelo.Animal[ id=" + id + " ]";
    }
    
}
