/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Cachorro;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public interface CachorroDao extends BaseDao<Cachorro, Long> {
    
    List<Cachorro> pesquisaPorNome (String nome, Session sessao) throws HibernateException;
    
}
