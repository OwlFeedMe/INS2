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
    private String disquera;
    private String FechaDeSalida;

    public Cancion(String Nombre, String disquera, String FechaDeSalida) {
        this.Nombre = Nombre;
        this.Artista = new ArrayList<Artista>();
        this.Album = new ArrayList<Album>();
        this.disquera = disquera;
        this.FechaDeSalida = FechaDeSalida;
    }

    public ArrayList<Artista> getArtista() {
        return Artista;
    }

    public void setArtista(ArrayList<Artista> Artista) {
        this.Artista = Artista;
    }

    public ArrayList<Album> getAlbum() {
        return Album;
    }

    public void setAlbum(ArrayList<Album> Album) {
        this.Album = Album;
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

    public String getDisquera() {
        return disquera;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public String getFechaDeSalida() {
        return FechaDeSalida;
    }

    public void setFechaDeSalida(String FechaDeSalida) {
        this.FechaDeSalida = FechaDeSalida;
    }

}
