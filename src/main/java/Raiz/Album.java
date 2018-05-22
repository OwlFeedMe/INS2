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
public class Album {
    private String Nombre;
    private ArrayList<Interprete> Interprete;
    private ArrayList<Cancion> Canciones;
    private String Disquera;
    private String FechaDeSalida;

    public Album(String Nombre, String Disquera, String FechaDeSalida) {
        this.Nombre = Nombre;
        this.Interprete = new ArrayList<Interprete>();
        this.Canciones = new ArrayList<Cancion>();
        this.Disquera = Disquera;
        this.FechaDeSalida = FechaDeSalida;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDisquera() {
        return Disquera;
    }

    public void setDisquera(String Disquera) {
        this.Disquera = Disquera;
    }

    public String getFechaDeSalida() {
        return FechaDeSalida;
    }

    public void setFechaDeSalida(String FechaDeSalida) {
        this.FechaDeSalida = FechaDeSalida;
    }
    public boolean Asignar_Interprete_Album(){
    
    
    return true;
    }
}
