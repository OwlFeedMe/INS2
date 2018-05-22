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
    private ArrayList<Artista> Interprete;
    private int PosAn;
    private int PosAc;
    private int NV;

    public Album(String Nombre, int PosAn, int PosAc, int NV) {
        this.Nombre = Nombre;
        this.PosAn = PosAn;
        this.PosAc = PosAc;
        this.NV = NV;
        this.Interprete= new ArrayList();
    }

    public ArrayList<Artista> getInterprete() {
        return Interprete;
    }

    public void setInterprete(Artista e) {
        this.Interprete.add(e);
    }

    

    public int getPosAn() {
        return PosAn;
    }

    public void setPosAn(int PosAn) {
        this.PosAn = PosAn;
    }

    public int getPosAc() {
        return PosAc;
    }

    public void setPosAc(int PosAc) {
        this.PosAc = PosAc;
    }

    public int getNV() {
        return NV;
    }

    public void setNV(int NV) {
        this.NV = NV;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

 
    public boolean Asignar_Interprete_Album() {

        return true;
    }
}
