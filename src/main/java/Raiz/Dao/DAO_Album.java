/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Album {

    private DB_Album DB;

    public DAO_Album() {
        this.DB = new DB_Album();
    }

    public boolean Insertar(Album a) {

        return DB.Insertar(a);
    }
    public ArrayList<Album> Listar() throws SQLException {

        return DB.Listar();
    }
    public Album BuscarAlbumPorNombre(String a) throws SQLException {

        return DB.buscarAlbumPorNombre(a);
    }

}
