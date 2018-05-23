/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz.Dao;

import Raiz.Album;
import Raiz.Cancion;
import Raiz.Ventas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.omg.CORBA.BAD_INV_ORDER;

/**
 *
 * @author user
 */
public class DAO_Ventas {

    private DB_Venta DB;

    public DAO_Ventas() {
        this.DB = new DB_Venta();
    }

    public boolean insertar(Cancion c, Album a, int ca) {
        Date date = new Date();

        Ventas ventas = new Ventas(date.getTime(), c, a, ca);
        DB.Insertar(ventas, ca);

        return true;
    }

    public ArrayList<Cancion> ListarCanciones(Long a) throws SQLException {

        return DB.buscarCanciones(a);
    }

    public ArrayList<Album> ListarAlbums(Long a) throws SQLException {

        return DB.buscarAlbumes(a);
    }
}
