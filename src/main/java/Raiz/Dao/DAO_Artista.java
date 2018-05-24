/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Artista;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Artista {

    private DB_Artista DB;

    public DAO_Artista() {
        this.DB = new DB_Artista();
    }

    public boolean Insertar(Artista a) {
        return DB.Insertar(a);
    }
    public Artista BuscarArtista(int a) throws SQLException {
        return DB.buscarArtista(a);
    }
    public Artista BuscarArtistaNombre(String a) throws SQLException {
        return DB.buscarArtistaNombre(a);
    }
    public ArrayList<Artista> ListarArtistas() throws SQLException {
        return DB.ListasArtistas();
    }

}
