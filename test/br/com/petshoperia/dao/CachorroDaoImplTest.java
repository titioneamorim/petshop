/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Animal;
import br.com.petshoperia.modelo.Cachorro;
import br.com.petshoperia.modelo.Dono;
import br.com.utilitario.UtilGerador;
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
public class CachorroDaoImplTest {
    
    private Cachorro cachorro;
    private Session sessao;
    private CachorroDao cachorroDao;
    private Dono dono;
    private DonoDao donoDao;
    
    public CachorroDaoImplTest() {
        cachorroDao = new CachorroDaoImpl();
    }

    @Test
    public void testSalvar(){
        System.out.println("testSalvar");
        cachorro = new Cachorro(null, 
                UtilGerador.gerarCaracter(3), 
                UtilGerador.gerarNome(), 
                UtilGerador.gerarCidade(),
                new Date(), 
                10.0,
                "Macho pacarai", 
                "Não há",
                false);
        
        criaDono();
        cachorro.setDono(dono);
        sessao = HibernateUtil.abrirConexao();
        cachorroDao.salvarOuAlterar(cachorro, sessao);
        sessao.close();
        
        assertNotNull(cachorro.getId());
    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscaCachorroBd();
        sessao = HibernateUtil.abrirConexao();
        cachorroDao.pesquisarPorId(cachorro.getId(), sessao);
        sessao.close();
        
        assertNotNull(cachorro);
    }

   // @Test
    public void testPesquisaPorNome() {
        System.out.println("pesquisaPorNome");
        buscaCachorroBd();
        sessao = HibernateUtil.abrirConexao();
        cachorroDao.pesquisaPorNome(cachorro.getNome(), sessao);
        sessao.close();
        
        assertNotNull(cachorro);
    }
    
  //  @Test
    public void testAlterar() {
        System.out.println("testAlterar");
        buscaCachorroBd();
        cachorro.setNome("Alterado " + UtilGerador.gerarNome());
        Cachorro cachorroAlterado = cachorro;
        sessao = HibernateUtil.abrirConexao();
        cachorroDao.salvarOuAlterar(cachorro, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        cachorro = cachorroDao.pesquisarPorId(cachorroAlterado.getId(), sessao);
        sessao.close();
        
        assertEquals(cachorroAlterado.getNome(), cachorro.getNome());
    }
   
    
//    @Test
    public void testExcluir() {
        System.out.println("testExcluir");
        buscaCachorroBd();
        sessao = HibernateUtil.abrirConexao();
        cachorroDao.excluir(cachorro, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        cachorro = cachorroDao.pesquisarPorId(cachorro.getId(), sessao);
        sessao.close();
        
        assertNull(cachorro);
    }
    
    
    
    
    public Animal buscaCachorroBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Cachorro");
        List<Cachorro> cachorros = consulta.list();
        sessao.close();
        
        if (cachorros.isEmpty()) {
            testSalvar();
        } else {
            cachorro = cachorros.get(0);
        }
        
        return cachorro;
    }
    public void criaDono(){
        donoDao = new DonoDaoImpl();
        dono = new Dono(null, 
                UtilGerador.gerarNome(), 
                UtilGerador.gerarNumero(11), 
                UtilGerador.gerarTelefoneFixo(), 
                UtilGerador.gerarEmail());
        
        sessao = HibernateUtil.abrirConexao();
        donoDao.salvarOuAlterar(dono, sessao);
        sessao.close();

    }
}
