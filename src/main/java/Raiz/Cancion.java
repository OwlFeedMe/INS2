package Raiz;


import java.util.ArrayList;

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
public class Cancion  implements Comparable<Object>{

    private String Nombre;
    private ArrayList<Artista> Artista ;
    private ArrayList<Album> Album;
    private int posicionAnterior;
    private int Aparicionesenlistas;
    private int NVentas;

    public Cancion(String Nombre, String posicionAnterior, String Aparicionesenlistas, int Nventas) {
        this.Nombre = Nombre;
        this.Artista = new ArrayList<Artista>();
        this.Album = new ArrayList<Album>();
      
        this.NVentas=Nventas;
    }

    public Cancion() {
    }

    public ArrayList<Artista> getArtista() {
        return Artista;
    }

    public int getNVentas() {
        return NVentas;
    }

    public void setNVentas(int NVentas) {
        this.NVentas = NVentas;
    }

    public void setArtista(ArrayList<Artista> Artista) {
        this.Artista = Artista;
    }
    public void setArtistaA(Artista e) {
        this.Artista.add(e);
    }
    public ArrayList<Album> getAlbum() {
        return Album;
    }

    public void setAlbum(ArrayList<Album> Album) {
        this.Album = Album;
    }
    public void setAlbumA(Album e) {
        this.Album.add(e);
    }

    public boolean Asignar_Artista_Cancion() {

        return true;
    }

    public int getPosicionAnterior() {
        return posicionAnterior;
    }

    public void setPosicionAnterior(int posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }

    public int getAparicionesenlistas() {
        return Aparicionesenlistas;
    }

    public void setAparicionesenlistas(int Aparicionesenlistas) {
        this.Aparicionesenlistas = Aparicionesenlistas;
    }

    public boolean Asignar_Album_Cancion() {

        return true;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

  

     @Override
    public int compareTo(Object comparestu) {
      int compareage=((Cancion)comparestu).getNVentas();
        /* For Ascending order*/
        return compareage-this.getNVentas();

        /* For Descending order do like this */}



}
