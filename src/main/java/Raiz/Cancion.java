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
    private ArrayList<Interprete> Interprete;
    private ArrayList<Album> Album;
    private String disquera;
    private String FechaDeSalida;

    public Cancion(String Nombre, String disquera, String FechaDeSalida) {
        this.Nombre = Nombre;
        this.Interprete = new ArrayList<Interprete>();
        this.Album = new ArrayList<Album>();
        this.disquera = disquera;
        this.FechaDeSalida = FechaDeSalida;
    }

    public boolean Asignar_Interprete_Cancion() {

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
