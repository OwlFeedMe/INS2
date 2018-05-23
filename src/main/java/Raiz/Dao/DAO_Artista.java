/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Artista;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Artista {

    private DB_Interprete DB;

    public DAO_Artista() {
        this.DB = new DB_Interprete();
    }

    public boolean Insertar(Artista a) {
        return DB.Insertar(a);
    }

    public ArrayList<Artista> ListarInterprete() {
        
        return null;
    }
}
