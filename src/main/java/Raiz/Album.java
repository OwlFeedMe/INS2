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
public class Album  implements Comparable {

    private String Nombre;
    private ArrayList<Artista> Interprete;
    private int PosAn;
    private int PosAc;
    private int NV;
    private int NVentas;

    public Album(String Nombre, int PosAn, int PosAc, int NVentas) {
        this.Nombre = Nombre;
        this.PosAn = PosAn;
        this.PosAc = PosAc;
        this.NVentas=0;
        this.Interprete= new ArrayList();
    }

    public Album() {
    }

    public int getNVentas() {
        return NVentas;
    }

    public void setNVentas(int NVentas) {
        this.NVentas = NVentas;
    }

    public ArrayList<Artista> getInterprete() {
        return Interprete;
    }

    public void setInterprete(Artista e) {
        this.Interprete.add(e);
    }
    

    public void setInterpreteS(ArrayList<Artista> e) {
        this.Interprete = e;
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

    @Override
    public String toString() {
        return "Album{" + "Nombre=" + Nombre + ", Interprete=" + Interprete + ", PosAn=" + PosAn + ", PosAc=" + PosAc + ", NV=" + NV + ", NVentas=" + NVentas + '}';
    }

    @Override
    public int compareTo(Object comparestu) {
      int compareage=((Album)comparestu).getNVentas();
        /* For Ascending order*/
        return compareage-this.getNVentas();

        /* For Descending order do like this */}
}
