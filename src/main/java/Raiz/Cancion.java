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
public class Cancion {

    private String Nombre;
    private ArrayList<Artista> Artista ;
    private ArrayList<Album> Album;
    private String posicionAnterior;
    private String Aparicionesenlistas;
    private int NVentas;

    public Cancion(String Nombre, String posicionAnterior, String Aparicionesenlistas, int Nventas) {
        this.Nombre = Nombre;
        this.Artista = new ArrayList<Artista>();
        this.Album = new ArrayList<Album>();
        this.posicionAnterior = posicionAnterior;
        this.Aparicionesenlistas = Aparicionesenlistas;
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

    public boolean Asignar_Album_Cancion() {

        return true;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPosicionAnterior() {
        return posicionAnterior;
    }

    public void setPosicionAnterior(String posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }

    public String getAparicionesenlistas() {
        return Aparicionesenlistas;
    }

    public void setAparicionesenlistas(String Aparicionesenlistas) {
        this.Aparicionesenlistas = Aparicionesenlistas;
    }



}
