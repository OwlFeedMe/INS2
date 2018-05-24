/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Artista;
import Raiz.Cancion;
import Raiz.ListaCancion;
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
public class DB_Cancion {
    
    public Connection connection;
    
    
    public DB_Cancion() {
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
    
    public boolean Insertar(Cancion a) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement

        // the mysql insert statement
        String query = " insert into Cancion "
                + " values( null , ? , ? , ? , null , null)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;
        
        try {
            
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, a.getNombre());
            String ar = "";
            for (int i = 0; i < a.getArtista().size(); i++) {
                if (i < a.getArtista().size() - 1) {
                    ar += a.getArtista().get(i).getId() + ",";
                    
                } else {
                    ar += a.getArtista().get(i).getId();
                }
                
            }
            preparedStmt.setString(2, ar);
            
            String arc = "";
            for (int i = 0; i < a.getAlbum().size(); i++) {
                if (i < a.getAlbum().size() - 1) {
                    arc += a.getAlbum().get(i).getNombre() + ",";
                    
                } else {
                    arc += a.getAlbum().get(i).getNombre();
                }
                
            }
            preparedStmt.setString(3, arc);

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
    
    public ArrayList<Cancion> buscarCancionesPorAutor(int a) throws SQLException {
        ArrayList<Cancion> arrayList = new ArrayList<Cancion>();
        Cancion Cancion = new Cancion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                boolean apa = false;
                // iterate through the java resultset
                Cancion.setNombre(rs.getString("nombre"));
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                
                ArrayList<Artista> aL = new ArrayList<Artista>();
                
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    if (db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])).getId() == a) {
                        apa = true;
                    }
                    aL.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                Cancion.setArtista(aL);
                
                String Almb = rs.getString("NombreAlbum");
                String[] AlmbA = Almb.split(",");
                ArrayList<Album> aLA = new ArrayList<Album>();
                
                DB_Album db_Albm = new DB_Album();
                for (int i = 0; i < ArtA.length; i++) {
                    aLA.add(db_Albm.buscarAlbumPorNombre(ArtA[i]));
                }
                Cancion.setAlbum(aLA);
                Cancion.setPosicionAnterior(rs.getString("posicionAnterior"));
                Cancion.setAparicionesenlistas(rs.getString("Aparicionesenlistas"));
                DB_Venta db_Venta = new DB_Venta();
                Cancion.setNVentas(db_Venta.buscarVentasCan(rs.getInt("id")));
                
                if (apa == true) {
                    arrayList.add(Cancion);
                }
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return arrayList;
    }
    
    public ArrayList<Cancion> buscarCanciones() throws SQLException {
        ArrayList<Cancion> arrayList = new ArrayList<Cancion>();
        
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                Cancion Cancion = new Cancion();
                boolean apa = false;
                // iterate through the java resultset
                Cancion.setNombre(rs.getString("nombre"));
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                
                ArrayList<Artista> aL = new ArrayList<Artista>();
                
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                   
                    aL.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                Cancion.setArtista(aL);
                
                String Almb = rs.getString("NombreAlbum");
                String[] AlmbA = Almb.split(",");
                ArrayList<Album> aLA = new ArrayList<Album>();
                
                DB_Album db_Albm = new DB_Album();
                for (int i = 0; i < ArtA.length; i++) {
                    aLA.add(db_Albm.buscarAlbumPorNombre(ArtA[i]));
                }
                Cancion.setAlbum(aLA);
                Cancion.setPosicionAnterior(rs.getString("posicionAnterior"));
                Cancion.setAparicionesenlistas(rs.getString("Aparicionesenlistas"));
                DB_Venta db_Venta = new DB_Venta();
                Cancion.setNVentas(db_Venta.buscarVentasCan(rs.getInt("id")));
                
               
                    arrayList.add(Cancion);
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return arrayList;
    }
    
    public ArrayList<Cancion> buscarCancionesPorAlbum(String a) throws SQLException {
        ArrayList<Cancion> arrayList = new ArrayList<Cancion>();
        Cancion Cancion = new Cancion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                boolean apa = false;
                // iterate through the java resultset
                Cancion.setNombre(rs.getString("nombre"));
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                
                ArrayList<Artista> aL = new ArrayList<Artista>();
                
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    
                    aL.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                Cancion.setArtista(aL);
                
                String Almb = rs.getString("NombreAlbum");
                if (Almb.length() > 0) {
                    String[] AlmbA = Almb.split(",");
                    ArrayList<Album> aLA = new ArrayList<Album>();
                    
                    DB_Album db_Albm = new DB_Album();
                    for (int i = 0; i < AlmbA.length; i++) {
                        System.out.println(AlmbA[i]);
                        if (db_Albm.buscarAlbumPorNombre(AlmbA[i]).getNombre().equals(a)) {
                            apa = true;
                        }
                        aLA.add(db_Albm.buscarAlbumPorNombre(AlmbA[i]));
                    }
                    Cancion.setAlbum(aLA);                    
                }
                
                Cancion.setPosicionAnterior(rs.getString("posicionAnterior"));
                Cancion.setAparicionesenlistas(rs.getString("Aparicionesenlistas"));
                DB_Venta db_Venta = new DB_Venta();
                Cancion.setNVentas(db_Venta.buscarVentasCan(rs.getInt("id")));
                
                if (apa == true) {
                    arrayList.add(Cancion);
                }
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return arrayList;
    }
    
    public Cancion buscarCancionPorId(int a, long b) throws SQLException {
        
        Cancion Cancion = new Cancion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion where id = " + a;
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {

                // iterate through the java resultset
                Cancion.setNombre(rs.getString("nombre"));
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                
                ArrayList<Artista> aL = new ArrayList<Artista>();
                
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    
                    aL.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                Cancion.setArtista(aL);
                
                String Almb = rs.getString("NombreAlbum");
                String[] AlmbA = Almb.split(",");
                ArrayList<Album> aLA = new ArrayList<Album>();
                
                DB_Album db_Albm = new DB_Album();
                for (int i = 0; i < ArtA.length; i++) {
                    
                    aLA.add(db_Albm.buscarAlbumPorNombre(ArtA[i]));
                }
                Cancion.setAlbum(aLA);
                Cancion.setPosicionAnterior(rs.getString("posicionAnterior"));
                Cancion.setAparicionesenlistas(rs.getString("Aparicionesenlistas"));
                DB_Venta db_Venta = new DB_Venta();
                Cancion.setNVentas(db_Venta.buscarVentasCanAntesDe(a, b));
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return Cancion;
    }
    
    public Cancion buscarCancionPorNombre(String a) throws SQLException {
        
        Cancion Cancion = new Cancion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion where nombre = '" + a+"'";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {

                // iterate through the java resultset
                Cancion.setNombre(rs.getString("nombre"));
                String Art = rs.getString("idArtista");
                String[] ArtA = Art.split(",");
                
                ArrayList<Artista> aL = new ArrayList<Artista>();
                
                DB_Artista db_Interprete = new DB_Artista();
                for (int i = 0; i < ArtA.length; i++) {
                    
                    aL.add(db_Interprete.buscarArtista(Integer.valueOf(ArtA[i])));
                }
                Cancion.setArtista(aL);
                
                String Almb = rs.getString("NombreAlbum");
                String[] AlmbA = Almb.split(",");
                ArrayList<Album> aLA = new ArrayList<Album>();
                
                DB_Album db_Albm = new DB_Album();
                for (int i = 0; i < ArtA.length; i++) {
                    
                    aLA.add(db_Albm.buscarAlbumPorNombre(ArtA[i]));
                }
                Cancion.setAlbum(aLA);
                Cancion.setPosicionAnterior(rs.getString("posicionAnterior"));
                Cancion.setAparicionesenlistas(rs.getString("Aparicionesenlistas"));
                DB_Venta db_Venta = new DB_Venta();
            
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return null;
        }
        
        return Cancion;
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
