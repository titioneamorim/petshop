/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Animal;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public class AnimalDaoImpl extends BaseDaoImpl<Animal, Long> implements AnimalDao, Serializable{

    @Override
    public Animal pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Animal) sessao.get(Animal.class, id);
    }

    @Override
    public List<Animal> pesquisaPorNome(String nome, Session sessao) throws HibernateException {
         Query consulta = sessao.createQuery("from Animal where nome like :nome");
        consulta.setParameter("nome", "%" + nome  + "%");
        return consulta.list();
    }
    
    
    
}
