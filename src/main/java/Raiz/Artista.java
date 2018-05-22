package Raiz;

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
public class Artista {
    private int id;
    private String Nombre_Apellido;
    private String NombreArtistico;
 

    public Artista(int id,String Nombre_Apellido, String NombreArtistico) {
        this.id=id;
        this.Nombre_Apellido = Nombre_Apellido;
        this.NombreArtistico = NombreArtistico;
        
       
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_Apellido() {
        return Nombre_Apellido;
    }

    public void setNombre_Apellido(String Nombre_Apellido) {
        this.Nombre_Apellido = Nombre_Apellido;
    }

    public String getNombreArtistico() {
        return NombreArtistico;
    }

    public void setNombreArtistico(String NombreArtistico) {
        this.NombreArtistico = NombreArtistico;
    }

   
}
