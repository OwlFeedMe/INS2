
import Raiz.Album;
import Raiz.Artista;
import Raiz.Dao.DAO_Album;
import Raiz.Dao.DB_Album;

/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */

/**
 *
 * @author user
 */
public class Pruebas {
    public static void main(String[] args) {
        
        
        
        DB_Album db_Album = new DB_Album();
        Artista artista = new Artista(1, "Rene", "Calle 13");
        Album album = new Album("Ojos Color Sol", 0, 0, 0);
        album.setInterprete(artista);
        
        db_Album.Insertar(album);
    }
}
