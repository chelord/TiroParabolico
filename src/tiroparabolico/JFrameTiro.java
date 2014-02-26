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
    private double tiempo;   // Tiempo de vuelo de la bola
    private final double gravedad = 9.8;   // Variable flotante que almacena el valor de la gravedad
    private boolean movBola;    // Bandera para verificar si la bola está en movimiento
    private boolean movJugador;     // Bandera para verificar si el jugador está en movimiento
    private int vidas;      // Variable entera que contará las vidas restantes del jugador
    private int puntos;     // Variable entera que contará los puntos acumulados por el jugador
    private long tiempoActual;
    private long tiempoInicial;
    private boolean pausa;      // Bandera que verifica si el jugador pausó el juego
    private boolean guardar;    // Bandera que verifica si el jugador quiere guardar el juego
    private boolean continuar;  // Bandera que verifica si el jugador quiere continuar un juego
    private double angulo;      // Angulo 
    private int maxVelInicial;     // Maxima velocidad inicial
    private int velocidad;
    
    
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
        posInicialy = 200;
        posicionXBola = 100;
        posicionYBola = 200;
        jugador = new Jugador(0, 0, 0);
        posicionXJugador = getWidth()/2;
        posicionYJugador = getHeight() - jugador.getAlto();
        jugador.setPosX(posicionXJugador);
        jugador.setPosY(posicionYJugador);
        tiempo = 0;
        movBola = false;
        movJugador = false;
        bola = new Bola(posInicialx, posInicialy);
        vidas = 5;
        puntos = 0;
        pausa = false;
        continuar = false;
        guardar = false;
        angulo = ((int)(Math.random() * ((89)) + 1));
        maxVelInicial = (int) Math.sqrt(((900 * gravedad) / Math.sin(2 * angulo)));
        bola.setVelocidadInicialX(1 + (int)(Math.random() * ((900 - 1) + 1)));
        bola.setVelocidadInicialY(1 + (int)(Math.random() * ((200 - 1) + 1)));
        /***
         * FALTA DECLARAR SONIDOS E IMPORTARLOS
         */
    }
    
     /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {
        // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }
    
    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
        tiempoActual = System.currentTimeMillis();
        while (vidas > 0) {
            if (!pausa) {
                actualiza();
                checaColision();
            }
            repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.
            try {
                // El thread se duerme.
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
    }
    
     /**
     * Metodo usado para actualizar la posicion de objetos bueno y malo.
     *
     */
    public void actualiza() {
        
    }
    
    /**
     * Metodo usado para checar las colisiones del objeto elefante y raton con
     * las orillas del <code>Applet</code>.
     */
    public void checaColision() {
        
    }
    
    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
                // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }
    
    public void keyPressed(KeyEvent e) {
        
    } 

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
                        
    }

    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @paramg es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {
        if (bola != null && jugador != null) {
            //Dibuja la imagen en la posicion actualizada
            g.drawImage(bola.getImagenI(), bola.getPosX(), bola.getPosY(), this);
            g.drawImage(jugador.getImagenI(), jugador.getPosX(), jugador.getPosY(), this);
            g.setColor(Color.black);
            g.drawString("Puntaje = " + puntos, 10, 15);

            if (pausa) {
                g.setColor(Color.white);
                g.drawString(bola.getPAUSADO(), bola.getPosX() + bola.getAncho() / 5, bola.getPosY() + bola.getAlto() / 2);
            }
        }
        else{
            //Da un mensaje mientras se carga el dibujo	
            g.drawString("No se cargo la imagen..", 20, 20);
        }
    }
}
