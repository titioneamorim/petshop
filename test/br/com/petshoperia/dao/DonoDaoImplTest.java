/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshoperia.dao;

import br.com.petshoperia.modelo.Animal;
import br.com.petshoperia.modelo.Dono;
import br.com.petshoperia.modelo.Gato;
import br.com.utilitario.UtilGerador;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Titione
 */
public class DonoDaoImplTest {
    
    private Dono dono;
    private DonoDao donoDao;
    private Session sessao;
    
    public DonoDaoImplTest() {
        
       donoDao = new DonoDaoImpl();
    }

    //@Test 
    public void testSalvar(){
        System.out.println("Salvar");
        dono = new Dono(null, 
                UtilGerador.gerarNome(), 
                UtilGerador.gerarNumero(11), 
                UtilGerador.gerarTelefoneFixo(), 
                UtilGerador.gerarEmail());
        
        sessao = HibernateUtil.abrirConexao();
        donoDao.salvarOuAlterar(dono, sessao);
        sessao.close();
        
        assertNotNull(dono.getId());           
    }
    
    
    // @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscaDonoBd();
        sessao = HibernateUtil.abrirConexao();
        donoDao.pesquisarPorId(dono.getId(), sessao);
        sessao.close();
        
        assertNotNull(dono);
    }

   // @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
         buscaDonoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Dono> donos = donoDao.pesquisarPorNome(dono.getNome(), sessao);
        sessao.close();
        
        assertNotNull(donos.get(0));
    }
//@Test
    
    public void testAlterar() {
        System.out.println("testAlterar");
        buscaDonoBd();
        dono.setNome("Alterado " + UtilGerador.gerarNome());
        Dono donoALterado = dono; 
        sessao = HibernateUtil.abrirConexao();
        donoDao.salvarOuAlterar(dono, sessao);
        sessao.close();
        sessao = HibernateUtil.abrirConexao();
        dono = donoDao.pesquisarPorId(dono.getId(), sessao);
        sessao.close();
        
        assertEquals(donoALterado.getNome(), dono.getNome());
    }
    
    
    @Test
    public void testExcluir(){
        System.out.println("Excluir");
        buscaDonoBd();
        sessao = HibernateUtil.abrirConexao();
        donoDao.excluir(dono, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Dono donoExcluido = donoDao.pesquisarPorId(dono.getId(), sessao);
        sessao.close();
        
        assertNull(donoExcluido);
    }
    
    
    
    public Dono buscaDonoBd(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Dono");
        List<Dono> donos = consulta.list();
        sessao.close();
        
        if (donos.isEmpty()) {
            testSalvar();
        } else {
            dono = donos.get(0);
        }
        
        return dono;
    }
    
}
