/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Cachorro;
import br.com.petshoperia.modelo.Gato;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public class GatoDaoImpl extends BaseDaoImpl<Gato, Long> implements GatoDao, Serializable{

    @Override
    public Gato pesquisarPorId(Long id, Session sessao) throws HibernateException {
         return (Gato) sessao.get(Gato.class, id);
    }

    @Override
    public List<Gato> pesquisaPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Gato where nome like :nome");
        consulta.setParameter("nome", "%" + nome  + "%");
        return consulta.list();
    }
    
    
    
}
