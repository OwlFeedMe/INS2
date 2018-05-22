/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Artista;
import Raiz.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        String query = " insert into Cancione "
                + " values( null , ? , ? , ? , null , null)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = null;

        try {

            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, a.getNombre());
            String ar="";
            for (int i = 0; i < a.getArtista().size(); i++) {
                if (i < a.getArtista().size() - 1) {
                    ar += a.getArtista().get(i).getId() + ",";
                   
                } else {
                     ar += a.getArtista().get(i).getId();
                }

            }
            preparedStmt.setString(2, ar);
            
            String arc="";
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

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
