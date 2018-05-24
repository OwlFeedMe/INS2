///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Raiz.Dao;
//
//import Raiz.Album;
//import Raiz.Cancion;
//import java.util.ArrayList;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author crist
// */
//public class DAO_VentasTest {
//    
//    public DAO_VentasTest() {
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
//     * Test of insertar method, of class DAO_Ventas.
//     */
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Cancion c = null;
//        Album a = null;
//        int ca = 0;
//        DAO_Ventas instance = new DAO_Ventas();
//        boolean expResult = false;
//        boolean result = instance.insertar(c, a, ca);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ListarCanciones method, of class DAO_Ventas.
//     */
//    @Test
//    public void testListarCanciones() throws Exception {
//        System.out.println("ListarCanciones");
//        Long a = null;
//        DAO_Ventas instance = new DAO_Ventas();
//        ArrayList<Cancion> expResult = null;
//        ArrayList<Cancion> result = instance.ListarCanciones(a);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ListarAlbums method, of class DAO_Ventas.
//     */
//    @Test
//    public void testListarAlbums() throws Exception {
//        System.out.println("ListarAlbums");
//        Long a = null;
//        DAO_Ventas instance = new DAO_Ventas();
//        ArrayList<Album> expResult = null;
//        ArrayList<Album> result = instance.ListarAlbums(a);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
