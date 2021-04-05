/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Dono;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Titione
 */
public interface DonoDao extends BaseDao<Dono, Long>{
    
    List<Dono> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    
}
