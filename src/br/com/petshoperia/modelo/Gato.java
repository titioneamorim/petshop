/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Titione
 */
@Entity
@Table(name = "gato")
@PrimaryKeyJoinColumn(name = "id_animal")
public class Gato extends Animal{
    
    @Column(name = "comportamento")
    private String comportamento;

    public Gato() {
    }

    public Gato(Long id, String codigo, String nome, String raca, Date nascimento, double peso, String sexo, String observacao, String comportamento) {
        super(id, codigo, nome, raca, nascimento, peso, sexo, observacao);
        this.comportamento = comportamento;
    }

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }
    
    
    
    
}
