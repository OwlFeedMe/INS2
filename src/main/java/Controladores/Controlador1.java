/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package Controladores;

import Raiz.Album;
import Raiz.Artista;
import Raiz.Cancion;
import Raiz.Dao.DAO_Album;
import Raiz.Dao.DAO_Artista;
import Raiz.Dao.DAO_Cancion;
import Raiz.Dao.DAO_Ventas;
import is2.Albumes;
import is2.Artistas;
import is2.Canciones;
import is2.ListaTodosLosAlbumes;
import is2.ListarPorAlbum;
import is2.ListarTodasLasCanciones;
import is2.Canciones;
import is2.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Controlador1 implements ActionListener, MouseListener{

    private Canciones Cancionview;
    private DAO_Cancion model;
    private Principal principal;
    private Albumes Albumview;
    private DAO_Album modelAlbum;
    private DAO_Ventas modeloVentas;
    private Artistas Artistaview;
    private DAO_Artista modelArtista;

    private ListaTodosLosAlbumes ListaAlbumesview;

    private ListarPorAlbum Lista;

    private ListarTodasLasCanciones listaCancion;

    public Controlador1() {

        this.Cancionview = new Canciones();
        this.model = new DAO_Cancion();
        this.Albumview = new Albumes();
        this.modelAlbum = new DAO_Album();
        this.Artistaview = new Artistas();
        this.modelArtista = new DAO_Artista();
        this.ListaAlbumesview = new ListaTodosLosAlbumes();
        this.listaCancion = new ListarTodasLasCanciones();
        this.Lista = new ListarPorAlbum();
        this.principal = new Principal();
        this.modeloVentas = new DAO_Ventas();

//        Canciones
        this.Cancionview.jButton1.addActionListener(this);
        this.Cancionview.jComboBox1.addActionListener(this);
        this.Cancionview.jComboBox2.addActionListener(this);
        this.Cancionview.jLabel7.addMouseListener(this);
        this.Cancionview.jLabel5.addMouseListener(this);

//        Album
        this.Albumview.jComboBox1.addActionListener(this);
        this.Albumview.jButton1.addActionListener(this);
        this.Albumview.jLabel7.addMouseListener(this);
        this.Albumview.jLabel5.addMouseListener(this);
        this.Albumview.jLabel12.addMouseListener(this);

//        Artista
        this.Artistaview.jButton1.addActionListener(this);
        this.Artistaview.jLabel7.addMouseListener(this);

//        Principal
        this.principal.jPanel3.addMouseListener(this);
        this.principal.jPanel5.addMouseListener(this);
        this.principal.jPanel9.addMouseListener(this);
        this.principal.setVisible(true);

//        Listas
        this.ListaAlbumesview.jButton1.addActionListener(this);
        this.ListaAlbumesview.jLabel5.addMouseListener(this); 
        
        
        this.Lista.jComboBox1.addActionListener(this);
        this.Lista.jLabel5.addMouseListener(this);
        
        this.listaCancion.jButton1.addActionListener(this);
        this.listaCancion.jLabel5.addMouseListener(this);

        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Cancionview.jButton1) {
            JOptionPane.showMessageDialog(null, "Guardado satisfactoriamente");
            Cancion veo = new Cancion(Cancionview.jTextField1.getText(), null, null, 0);
            String[] arA = Cancionview.jLabel14.getText().split(",");
            for (int i = 0; i < arA.length; i++) {
                try {
                    veo.setArtistaA(modelArtista.BuscarArtistaNombre(arA[i]));
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (Cancionview.jLabel15.getText().length() > 0) {
                String[] arB = Cancionview.jLabel15.getText().split(",");
                for (int i = 0; i < arB.length; i++) {
                    try {
                        veo.setAlbumA(modelAlbum.BuscarAlbumPorNombre(arB[i]));
                    } catch (SQLException ex) {
                        Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            model.Insertar(veo);
        }

        if (e.getSource() == Cancionview.jComboBox1) {
            Cancionview.jLabel14.setText((String) Cancionview.jComboBox1.getSelectedItem());
        }
        if (e.getSource() == Cancionview.jComboBox2) {
            Cancionview.jLabel15.setText((String) Cancionview.jComboBox2.getSelectedItem());
        }

        if (e.getSource() == Albumview.jButton1) {
            JOptionPane.showMessageDialog(null, "Guardado satisfactoriamente");
            Album al = new Album(Albumview.jTextField1.getText(), 0, 0, 0);
            String[] arA = Albumview.jLabel14.getText().split(",");
            for (int i = 0; i < arA.length; i++) {
                try {
                    al.setInterprete(modelArtista.BuscarArtistaNombre(arA[i]));
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(arA[0]);
            modelAlbum.Insertar(al);

        }

        if (e.getSource() == Artistaview.jButton1) {
            JOptionPane.showMessageDialog(null, "Guardado satisfactoriamente");
            Artista artista = new Artista(0, Artistaview.jTextField1.getText(), Artistaview.jTextField2.getText());
            modelArtista.Insertar(artista);
        }
        
        if (e.getSource() == ListaAlbumesview.jButton1) {
            JOptionPane.showMessageDialog(null, "Listado satisfactoriamente");
            Date date = ListaAlbumesview.jDateChooser2.getDate();
            try {
                modeloVentas.ListarAlbums(date.getTime());
            } catch (SQLException ex) {
                Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { System.out.println(e);
    }

    @Override
    public void mousePressed(MouseEvent e) { System.out.println(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e);
        // Principal
        if (e.getSource() == principal.jPanel3) {
            try {
                RellenarCombo();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
            }
            Cancionview.jLabel14.setText("");
            Cancionview.artistas="";
            Cancionview.jLabel15.setText("");
            Cancionview.albumes="";
            principal.setVisible(false);
            Cancionview.setVisible(true);
             

        }
        if (e.getSource() == principal.jPanel5) {

            try {
                RellenarCombo();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
            }
            Albumview.jLabel14.setText("");
            Albumview.artistas = "";
            principal.setVisible(false);
            Albumview.setVisible(true);
             

        }
        if (e.getSource() == principal.jPanel9) {
            principal.setVisible(false);
            Artistaview.setVisible(true);
             
        }

        // Canciones
        if (e.getSource() == Cancionview.jLabel7) {
            Cancionview.setVisible(false);
            principal.setVisible(true);
             
        }
        if (e.getSource() == Cancionview.jLabel5) {
            Cancionview.setVisible(false);
            listaCancion.setVisible(true);
             
        }

        // Lista Canciones
        if (e.getSource() == listaCancion.jLabel5) {
            listaCancion.setVisible(false);
            Cancionview.setVisible(true);
             
        }

        // Album
        if (e.getSource() == Albumview.jLabel7) {
            Albumview.setVisible(false);
            principal.setVisible(true);
             
        }
        if (e.getSource() == Albumview.jLabel5) {
            Albumview.setVisible(false);
            ListaAlbumesview.setVisible(true);
           
          
             
        }
        if (e.getSource() == Albumview.jLabel12) {
            Albumview.setVisible(false);
            Lista.setVisible(true);
             
        }

        //Lista
        if (e.getSource() == Lista.jLabel5) {
            Lista.setVisible(false);
            Albumview.setVisible(true);
             
        }

        //Lista Completa
        if (e.getSource() == ListaAlbumesview.jLabel5) {
            ListaAlbumesview.setVisible(false);
            Albumview.setVisible(true);
             
        }

        //Artista
        if (e.getSource() == Artistaview.jLabel7) {
            Artistaview.setVisible(false);
            principal.setVisible(true);
             
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void RellenarCombo() throws SQLException {
        Albumview.jComboBox1.removeAllItems();

        Cancionview.jComboBox1.removeAllItems();
        Cancionview.jComboBox2.removeAllItems();
        ArrayList<Artista> Artistas = modelArtista.ListarArtistas();
        ArrayList<Album> Album = modelAlbum.Listar();
        for (int i = 0; i < Artistas.size(); i++) {
            Albumview.jComboBox1.addItem(Artistas.get(i).getNombreArtistico());
            Cancionview.jComboBox1.addItem(Artistas.get(i).getNombreArtistico());
   
        }
        for (int i = 0; i < Album.size(); i++) {
            Cancionview.jComboBox2.addItem(Album.get(i).getNombre());
        }
           
    }

  
}
