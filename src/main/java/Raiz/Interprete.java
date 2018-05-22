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
public class Interprete {

    private String Nombre_Apellido;
    private String NombreArtistico;
    private String Disquera;
    private int Edad;

    public Interprete(String Nombre_Apellido, String NombreArtistico, String Disquera, int Edad) {
        this.Nombre_Apellido = Nombre_Apellido;
        this.NombreArtistico = NombreArtistico;
        this.Disquera = Disquera;
        this.Edad = Edad;
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

    public String getDisquera() {
        return Disquera;
    }

    public void setDisquera(String Disquera) {
        this.Disquera = Disquera;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

}
