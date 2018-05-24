/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Artista;
import Raiz.ListaCancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author user
 */
public class DB_Album {
    
    public Connection connection;
    
    public DB_Album() {
        conectar();
    }
    
    public void conectar() {
        
        System.out.println("-------- MySQL JDBC Connection Testing ------------");
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("MySQL JDBC Driver Registered!");
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root", "");
            
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        
    }
    
    public boolean Insertar(Album a) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement

        // the mysql insert statement
        String query = " insert into Album "
                + " values( ? , ? , null , null )";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;
        
        try {
            
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, a.getNombre());
            String ar = "";
            for (int i = 0; i < a.getInterprete().size(); i++) {
                if (i < a.getInterprete().size() - 1) {
                    ar += a.getInterprete().get(i).getId() + ",";
                    
                } else {
                    ar += a.getInterprete().get(i).getId();
                }
                
            }
            preparedStmt.setString(2, ar);

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
    
    public Album buscarAlbumPorNombre(String a) throws SQLException {
        
        Album album = new Album();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM Album  where nombre = " + "'"+a+"'";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                // iterate through the java resultset
                album.setNombre(a);
                
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                ArrayList<Artista> arrayList = new ArrayList<Artista>();
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    arrayList.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                
                album.setInterpreteS(arrayList);
                
                album.setNV(rs.getInt("Aparicionesenlistas"));
                album.setPosAn(rs.getInt("posicionAnterior"));
                DB_Venta db_Venta = new DB_Venta();
                album.setNVentas(0);
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return album;
    }
    
    public Album buscarCancionesConventas(String a, long b) throws SQLException {
        
        Album album = new Album();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM Album  where nombre = " + a;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                // iterate through the java resultset
                album.setNombre(a);
                
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                ArrayList<Artista> arrayList = new ArrayList<Artista>();
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    arrayList.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                
                album.setInterpreteS(arrayList);
                
                album.setNV(rs.getInt("Aparicionesenlista"));
                album.setPosAn(rs.getInt("posicionAnterior"));
                DB_Venta db_Venta = new DB_Venta();
                album.setNVentas(db_Venta.buscarVentasAlbAntesDe(a, b));
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return album;
    }
    
    public ArrayList<Album> Listar() throws SQLException {
        ArrayList<Album> arrayListF = new ArrayList<Album>();
        
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM Album";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Album album = new Album();
                // iterate through the java resultset
                album.setNombre(rs.getString("nombre"));
                
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                ArrayList<Artista> arrayList = new ArrayList<Artista>();
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    arrayList.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                
                album.setInterpreteS(arrayList);
                
                album.setNV(rs.getInt("Aparicionesenlistas"));
                album.setPosAn(rs.getInt("posicionAnterior"));
                arrayListF.add(album);
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return arrayListF;
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
