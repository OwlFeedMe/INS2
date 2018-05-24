/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Artista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DB_Artista {
    
    public Connection connection;
    
    public DB_Artista() {
        conectar();
    }
    
    public void conectar() {
        
//        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
//        System.out.println("MySQL JDBC Driver Registered!");
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root", "");
            
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        
        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        
    }
    
    public boolean Insertar(Artista a) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement

        // the mysql insert statement
        String query = " insert into Artista "
                + " values( null , ? , ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;
        
        try {
            
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, a.getNombre_Apellido());
            preparedStmt.setString(2, a.getNombreArtistico());

            // execute the preparedstatement
            preparedStmt.execute();
            
            System.out.println("You made it, the insertion is ok!");
            
        } catch (SQLException ee) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make insertion!");
            
            ee.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Artista buscarArtista(int a) throws SQLException {
        
        Artista artista = new Artista();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM Artista  where id = " + a;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                // iterate through the java resultset
                artista.setId(a);
                artista.setNombre_Apellido(rs.getString("nombreReal"));
                artista.setNombreArtistico(rs.getString("nombre"));
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return artista;
    }
    
    public Artista buscarArtistaNombre(String a) throws SQLException {
        
        Artista artista = new Artista();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Artista where nombre = '" + a + "'";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                // iterate through the java resultset
                artista.setId(rs.getInt("id"));
                artista.setNombre_Apellido(rs.getString("nombreReal"));
                artista.setNombreArtistico(rs.getString("nombre"));
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return artista;
    }
    
    public ArrayList<Artista> ListasArtistas() {
        ArrayList<Artista> Artistas = new ArrayList<Artista>();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT * FROM Artista";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                // iterate through the java resultset
                Artista artista = new Artista();
                artista.setId(rs.getInt("id"));
                artista.setNombre_Apellido(rs.getString("nombreReal"));
                artista.setNombreArtistico(rs.getString("nombre"));
                Artistas.add(artista);
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return Artistas;
    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
