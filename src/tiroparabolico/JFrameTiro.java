/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiroparabolico;

/**
 *
 * @author CSG
 */
import java.applet.Applet;
import java.awt.Rectangle;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.LinkedList;
import java.awt.Point;
import javax.swing.JFrame;

public class JFrameTiro extends JFrame implements Runnable, KeyListener, MouseListener{
    
    private static final long serialVersionUID = 1L;
    private Image dbImage;	// Imagen
    private Graphics dbg;	// Objeto grafico
    private SoundClip sonido;    // Objeto SoundClip para colision bola-jugador
    private SoundClip sonido2;    // Objeto SoundClip para colision bola-fondo del applet
    private Bola bola;    // Objeto de la clase Bola
    private Jugador jugador;   //Objeto de la clase Jugador
    private int posInicialx;     // Posicion inicial en x de la bola
    private int posInicialy;    // Posicion inicial en y de la bola
    private int posicionXBola;  // Posicion en x actual de la bola
    private int posicionYBola;  // Posicion en y actual de la bola
    private int posicionXJugador;  // Posicion en x actual del jugador
    private int posicionYJugador;  // Posicion en y actual del jugador
    private float tiempo;   // Tiempo de vuelo de la bola
    private final double gravedad = 9.8;   // Variable flotante que almacena el valor de la gravedad
    
    
    public JFrameTiro(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Examen"); setSize(1100, 700);
        init();
        start();
    }
    
    public void init(){
        this.setSize(1000, 700);
        addKeyListener(this);   
        addMouseListener(this);
        posInicialx = 100;
        posInicialy = 100;
        posicionXBola = 100;
        posicionYBola = 200;
        jugador = new Jugador(0, 0);
        posicionXJugador = getWidth()/2;
        posicionYJugador = getHeight() - 
        
    }
    
}
