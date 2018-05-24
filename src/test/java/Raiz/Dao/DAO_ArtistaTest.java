///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Raiz.Dao;
//
//import Raiz.Artista;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author crist
// */
//public class DAO_ArtistaTest {
//    
//    public DAO_ArtistaTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of Insertar method, of class DAO_Artista.
//     */
//    Artista ar = new Artista(1, "Shakira","Isabel");
//    @Test
//    public void testInsertar() {
//        System.out.println("Insertar");
//        DAO_Artista instance = new DAO_Artista();
//        boolean expResult = true;
//        boolean result = instance.Insertar(ar);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of BuscarArtista method, of class DAO_Artista.
//     */
//    @Test
//    public void testBuscarArtista() throws Exception {
//        System.out.println("BuscarArtista");
//        int a = 1;
//        DAO_Artista instance = new DAO_Artista();
//        Artista expResult = ar;
//        Artista result = instance.BuscarArtista(a);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of BuscarArtistaNombre method, of class DAO_Artista.
//     */
//    @Test
//    public void testBuscarArtistaNombre() throws Exception {
//        System.out.println("BuscarArtistaNombre");
//        String a = "Shakira";
//        DAO_Artista instance = new DAO_Artista();
//        Artista expResult = ar;
//        Artista result = instance.BuscarArtistaNombre(a);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ListarArtistas method, of class DAO_Artista.
//     */
//    @Test
//    public void testListarArtistas() throws Exception {
//        System.out.println("ListarArtistas");
//        DAO_Artista instance = new DAO_Artista();
//        ArrayList<Artista> arrayLista = new ArrayList<>();
//        ArrayList<Artista> expResult = arrayLista;
//        ArrayList<Artista> result = instance.ListarArtistas();
//        assertEquals(expResult, result);
//    }
//    
//}
