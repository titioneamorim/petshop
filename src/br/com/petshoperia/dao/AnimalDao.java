/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Animal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public interface AnimalDao extends BaseDao<Animal, Long>{
    
    List<Animal> pesquisaPorNome (String nome, Session sessao) throws HibernateException;

    
}
