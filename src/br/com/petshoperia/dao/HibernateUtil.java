/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;


import br.com.petshoperia.modelo.Animal;
import br.com.petshoperia.modelo.Cachorro;
import br.com.petshoperia.modelo.Dono;
import br.com.petshoperia.modelo.Gato;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Titione
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Animal.class);
            cfg.addAnnotatedClass(Dono.class);
            cfg.addAnnotatedClass(Cachorro.class);
            cfg.addAnnotatedClass(Gato.class);
            
            cfg.configure("/br/com/petshoperia/dao/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session abrirConexao() {
        return sessionFactory.openSession();
    }
}
