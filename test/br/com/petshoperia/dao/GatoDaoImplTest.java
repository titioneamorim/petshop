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
public class GatoDaoImplTest {
    
    private Gato gato;
    private Session sessao;
    private GatoDao gatoDao;
    private Dono dono;
    private DonoDao donoDao;
    
    public GatoDaoImplTest() {
        gatoDao = new GatoDaoImpl();
    }

     @Test
    public void testSalvar(){
        System.out.println("testSalvar");
        gato = new Gato(null, 
                UtilGerador.gerarCaracter(3),
                UtilGerador.gerarNome(), 
                UtilGerador.gerarCidade(),
                new Date(), 
                10.0,
                "Macho pacarai", 
                "Não há",
                "Brabo que é um XUXU");
        criaDono();
        gato.setDono(dono);
        
        sessao = HibernateUtil.abrirConexao();
        gatoDao.salvarOuAlterar(gato, sessao);
        sessao.close();
        
        assertNotNull(gato.getId());
    }
    
   //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscaGatoBd();
        sessao = HibernateUtil.abrirConexao();
        gatoDao.pesquisarPorId(gato.getId(), sessao);
        sessao.close();
        
        assertNotNull(gato);
    }

   // @Test
    public void testPesquisaPorNome() {
        System.out.println("pesquisaPorNome");
        buscaGatoBd();
        sessao = HibernateUtil.abrirConexao();
        gatoDao.pesquisaPorNome(gato.getNome(), sessao);
        sessao.close();
        
        assertNotNull(gato);
    }
    
//    @Test
    public void testAlterar() {
        System.out.println("testAlterar");
        buscaGatoBd();
        gato.setNome("Alterado " + UtilGerador.gerarNome());
        Gato gatoAlterado = gato;
        sessao = HibernateUtil.abrirConexao();
        gatoDao.salvarOuAlterar(gato, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        gato = gatoDao.pesquisarPorId(gatoAlterado.getId(), sessao);
        sessao.close();
        
        assertEquals(gatoAlterado.getNome(), gato.getNome());
    }
   
    
//    @Test
    public void testExcluir() {
        System.out.println("testExcluir");
        buscaGatoBd();
        sessao = HibernateUtil.abrirConexao();
        gatoDao.excluir(gato, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        gato = gatoDao.pesquisarPorId(gato.getId(), sessao);
        sessao.close();
        
        assertNull(gato);
    }
    
    
    
    
    public Animal buscaGatoBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Gato");
        List<Gato> gatos = consulta.list();
        sessao.close();
        
        if (gatos.isEmpty()) {
            testSalvar();
        } else {
            gato = gatos.get(0);
        }
        
        return gato;
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
