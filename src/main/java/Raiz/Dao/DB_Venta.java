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
import Raiz.ListaAlbum;
import Raiz.ListaCancion;
import Raiz.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author user
 */
public class DB_Venta {

    public Connection connection;

    public DB_Venta() {
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

    public boolean Insertar(Ventas a, int cantidad) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement

        // the mysql insert statement
        String query = " insert into Ventas "
                + " values( null , ? , ? , ? , ? )";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setLong(1, a.getFecha());
            preparedStmt.setInt(2,BuscarId(a.getCancion().getNombre()));
            if (a.getAlbum() != null) {
                preparedStmt.setString(3, a.getAlbum().getNombre());
            } else {
                preparedStmt.setString(3, null);
            }
            preparedStmt.setInt(4, a.getCantidas());

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

    public int buscarVentasCan(int a) throws SQLException {
        ArrayList<ListaCancion> arrayList = new ArrayList<ListaCancion>();
        ListaCancion listaCancion = new ListaCancion();
        int res = 0;
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Ventas  where idCancion = " + a;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                // iterate through the java resultset
                res += rs.getInt("Cantidad");
            }
            // print the results
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return 0;
        }

        return res;
    }

    public int buscarVentasCanAntesDe(int a, long b) throws SQLException {

        int res = 0;
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Ventas  where idCancion = " + a + " and Fecha < " + b;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                // iterate through the java resultset
                res += rs.getInt("Cantidad");
            }
            // print the results
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return 0;
        }

        return res;
    }

    public int buscarVentasAlbAntesDe(String a, long b) throws SQLException {

        int res = 0;
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Ventas  where NombreAlbum = '" + a + "' and Fecha < " + b + " and idCancion=0";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                // iterate through the java resultset
                res += rs.getInt("Cantidad");
            }
            // print the results
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return 0;
        }

        return res;
    }

    public ArrayList<Cancion> buscarCanciones(Long a) throws SQLException {
        ArrayList<Cancion> arrayList = new ArrayList<Cancion>();
        ListaCancion listaCancion = new ListaCancion();
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Ventas  where NombreAlbum = null and Fecha <" + a;
            ResultSet rs = st.executeQuery(query);
            DB_Cancion db_Cancion = new DB_Cancion();
            while (rs.next()) {
                // iterate through the java resultset
                arrayList.add(db_Cancion.buscarCancionPorId(rs.getInt("idCancion"), a));

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

    public ArrayList<Album> buscarAlbumes(Long a) throws SQLException {
        ArrayList<Album> arrayList = new ArrayList<Album>();

        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Ventas  where idCancion=0 and Fecha <" + a;
            ResultSet rs = st.executeQuery(query);
            DB_Album db_Album = new DB_Album();
            while (rs.next()) {
                // iterate through the java resultset
                Album album = db_Album.buscarAlbumPorNombre(rs.getString("NombreAlbum"));

                album.setNVentas(buscarVentasAlbAntesDe(album.getNombre(), a));
                boolean ing = true;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).getNombre().equals(rs.getString("NombreAlbum"))) {
                        ing = false;
                    }
                }
                if (ing) {

                    arrayList.add(album);
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
        Collections.sort(arrayList);
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            ActualizarNventasYPos(arrayList.get(i), i + 1);
        }
        return arrayList;
    }

    public int BuscarId(String a) {

       int id=0;
        try {
            // create the java statement

            Statement st = connection.createStatement();

            // execute the query, and get a java resultset
            String query = "SELECT  * FROM  Cancion where nombre = '" + a+"'";
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {

                id= rs.getInt("id");
                
            }
            // print the results
            st.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
            return 0;
        }
        
        return id;
    }

    public boolean ActualizarNventasYPos(Album a, int v) {
//        Insertion 
//	 create a sql date object so we can use it in our INSERT statement

        // the mysql insert statement
        String query = " update Album set posicionAnterior = " + v + " , Aparicionesenlistas = " + (a.getNV() + 1) + " where nombre = '" + a.getNombre() + "'";
        System.out.println(query);

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);

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

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
