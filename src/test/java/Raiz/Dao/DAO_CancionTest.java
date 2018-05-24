///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Raiz.Dao;
//
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
//public class DAO_CancionTest {
//    
//    public DAO_CancionTest() {
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
//     * Test of Insertar method, of class DAO_Cancion.
//     */  
//    Cancion can = new Cancion("luz", "1", "2", 3);
//    @Test
//    public void testInsertar() {
//        System.out.println("Insertar");
//        DAO_Cancion instance = new DAO_Cancion();
//        boolean expResult = true;
//        boolean result = instance.Insertar(can);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ListarPorInterprete method, of class DAO_Cancion.
//     */
//    ArrayList<Cancion> LisCan = new ArrayList<>();
//    @Test
//    public void testListarPorInterprete() throws Exception {
//        System.out.println("ListarPorInterprete");
//        int a = 1;
//        DAO_Cancion instance = new DAO_Cancion();
//        ArrayList<Cancion> expResult = LisCan;
//        ArrayList<Cancion> result = instance.ListarPorInterprete(a);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ListarPorAlbum method, of class DAO_Cancion.
//     */
//    @Test
//    public void testListarPorAlbum() throws Exception {
//        System.out.println("ListarPorAlbum");
//        String a = "Ojos Claros";
//        DAO_Cancion instance = new DAO_Cancion();
//        ArrayList<Cancion> expResult = LisCan;
//        ArrayList<Cancion> result = instance.ListarPorAlbum(a);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of BuscarPorNombre method, of class DAO_Cancion.
//     */
//    @Test
//    public void testBuscarPorNombre() throws Exception {
//        System.out.println("BuscarPorNombre");
//        String a = "luz";
//        DAO_Cancion instance = new DAO_Cancion();
//        Cancion expResult = can;
//        Cancion result = instance.BuscarPorNombre(a);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of ListarCancion method, of class DAO_Cancion.
//     */
//    ArrayList<Cancion> Todas = new ArrayList<>();
//    @Test
//    public void testListarCancion() throws Exception {
//        System.out.println("ListarCancion");
//        DAO_Cancion instance = new DAO_Cancion();
//        ArrayList<Cancion> expResult = Todas;
//        ArrayList<Cancion> result = instance.ListarCancion();
//        assertEquals(expResult, result);
//    }
//    
//}
