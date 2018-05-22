/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Raiz;

/**
 *
 * @author user
 */
public class Ventas {
    private Long Fecha;
    private Cancion Cancion;
    private Album Album;
    private int Cantidas;

    public Ventas(Long Fecha, Cancion Cancion, Album Album, int Cantidas) {
        this.Fecha = Fecha;
        this.Cancion = Cancion;
        this.Album = Album;
        this.Cantidas = Cantidas;
    }

    public Long getFecha() {
        return Fecha;
    }

    public void setFecha(Long Fecha) {
        this.Fecha = Fecha;
    }

    public Cancion getCancion() {
        return Cancion;
    }

    public void setCancion(Cancion Cancion) {
        this.Cancion = Cancion;
    }

    public Album getAlbum() {
        return Album;
    }

    public void setAlbum(Album Album) {
        this.Album = Album;
    }

    public int getCantidas() {
        return Cantidas;
    }

    public void setCantidas(int Cantidas) {
        this.Cantidas = Cantidas;
    }
    
    
    
}
