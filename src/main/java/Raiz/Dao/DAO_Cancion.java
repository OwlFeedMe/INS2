/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Cancion;
import Raiz.Artista;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Cancion {

    private DB_Cancion DB;

    public DAO_Cancion() {
        this.DB = new DB_Cancion();

    }

    public boolean Insertar(Cancion a) {

        return DB.Insertar(a);
    }

    public ArrayList<Cancion> ListarPorInterprete(int a) throws SQLException {
        return DB.buscarCancionesPorAutor(a);
    }

    public ArrayList<Cancion> ListarPorAlbum(String a) throws SQLException {
        return DB.buscarCancionesPorAlbum(a);
    }
}
