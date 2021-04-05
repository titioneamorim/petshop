/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Cachorro;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public class CachorroDaoImpl extends BaseDaoImpl<Cachorro, Long> implements CachorroDao, Serializable{

    @Override
    public Cachorro pesquisarPorId(Long id, Session sessao) throws HibernateException {
         return (Cachorro) sessao.get(Cachorro.class, id);
    }

    @Override
    public List<Cachorro> pesquisaPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Cachorro where nome like :nome");
        consulta.setParameter("nome", "%" + nome  + "%");
        return consulta.list();
    }
    
    
    
}
