/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Animal;
import br.com.utilitario.UtilGerador;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Titione
 */
public class AnimalDaoImplTest {
    
    private Animal animal;
    private Session sessao;
    private AnimalDao animalDao;
    
    
    public AnimalDaoImplTest() {
        animalDao = new AnimalDaoImpl();
    }

    @Test
    public void testSalvar(){
        System.out.println("testSalvar");
        animal = new Animal(null, 
                UtilGerador.gerarCaracter(3), 
                UtilGerador.gerarNome(), 
                UtilGerador.gerarCidade(),
                new Date(), 
                10.0, 
                "Macho", 
                "Não há");
        sessao = HibernateUtil.abrirConexao();
        animalDao.salvarOuAlterar(animal, sessao);
        sessao.close();
        
    }
    
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        Long id = null;
        Session sessao = null;
        AnimalDaoImpl instance = new AnimalDaoImpl();
        Animal expResult = null;
        Animal result = instance.pesquisarPorId(id, sessao);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisaPorNome() {
        System.out.println("pesquisaPorNome");
        String nome = "";
        Session sessao = null;
        AnimalDaoImpl instance = new AnimalDaoImpl();
        List<Animal> expResult = null;
        List<Animal> result = instance.pesquisaPorNome(nome, sessao);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
 
    public Animal buscaAnimalBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Animal");
        List<Animal> animais = consulta.list();
        sessao.close();
        
        if (animais.isEmpty()) {
            testSalvar();
        } else {
            animal = animais.get(0);
        }
        
        return animal;
    }
    
    
    
}
