package tiroparabolico;

/**
 * Clase Base
 * @author CSG
 */

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Base {
	
	private int posX;    //posicion en x.       
	private int posY;	//posicion en y.
	protected Animacion anima;    //icono.
	
	/**
	 * Metodo constructor usado para crear el objeto
	 * @param posX es la <code>posicion en x</code> del objeto.
	 * @param posY es la <code>posicion en y</code> del objeto.
	 * @param anima es la <code>animación</code> del objeto.
	 */
	public Base(int posX, int posY) {
		this.posX=posX;
		this.posY=posY;
		this.anima = new Animacion();
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en x del objeto 
	 * @param posX es la <code>posicion en x</code> del objeto.
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en x del objeto 
	 * @return posX es la <code>posicion en x</code> del objeto.
	 */
	public int getPosX() {
		return posX;
	}
	
	/**
	 * Metodo modificador usado para cambiar la posicion en y del objeto 
	 * @param posY es la <code>posicion en y</code> del objeto.
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Metodo de acceso que regresa la posicion en y del objeto 
	 * @return posY es la <code>posicion en y</code> del objeto.
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getAncho() {
		return (new ImageIcon(anima.getImagen())).getIconWidth();
	}
	
	/**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public int getAlto() {
                return (new ImageIcon(anima.getImagen())).getIconHeight();
	}
	
	/**
	 * Metodo de acceso que regresa la animación de un objeto Base 
	 * @return la animación de un objeto <code>Animación</code>.
	 */
	public Animacion getImagenes() {
		return this.anima;
	}
	
	/**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es el perimetro 
	 * del rectangulo
	 */
	public Rectangle getPerimetro(){
		return new Rectangle(getPosX(),getPosY(),getAncho(),getAlto());
	}
	
	/**
	 * Checa si el objeto <code>Base</code> intersecta a otro <code>Base</code>
	 *
	 * @return un valor boleano <code>true</code> si lo intersecta <code>false</code>
	 * en caso contrario
	 */
	public boolean intersecta(Base obj){
		return getPerimetro().intersects(obj.getPerimetro());
	}
	
        /**
	 * Checa si el objeto <code>Base</code> contiene un evento de click dentro de su rectángulo
	 *
	 * @return un valor boleano <code>true</code> si lo contiene, <code>false</code>
	 * en caso contrario
	 */
        public boolean contiene(int posX, int posY) {
                return getPerimetro().contains(posX, posY);
        }
        
        /**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es un cuarto del applet
         * 
	 */
        public Rectangle getCuadrante1(int width, int height) {                           
                int x = width / 2;
                int y = 0;
                int x2 = width;
                int y2 = height/2;

                return new Rectangle(x, y, x2, y2);
        }
        
                /**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es un cuarto del applet
         * 
	 */
        public Rectangle getCuadrante2(int width, int height) {                           
                int x = width / 2;
                int y = height / 2;
                int x2 = width;
                int y2 = height;

                return new Rectangle(x, y, x2, y2);
        }
        
                /**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es un cuarto del applet
         * 
	 */
        public Rectangle getCuadrante3(int width, int height) {                           
                int x = 0;
                int y = height / 2;
                int x2 = width / 2;
                int y2 = height;

                return new Rectangle(x, y, x2, y2);
        }
        
                /**
	 * Metodo de acceso que regresa un nuevo rectangulo
	 * @return un objeto de la clase <code>Rectangle</code> que es un cuarto del applet
         *
	 */
        public Rectangle getCuadrante4(int width, int height) {                           
                int x = 0;
                int y = 0;
                int x2 = width / 2;
                int y2 = height/2;

                return new Rectangle(x, y, x2, y2);
        }
        
        /**
	 * Actualiza el tiempo <code> temp </code> de la animación del objeto Base
	 */
        public void actualiza(long temp){
                anima.actualiza(temp);
        }
        
        /**
	 * Metodo de acceso que regresa la imagen actual de la animación 
	 * @return un ImageIcon que representa la imagen actual de la animación
	 */
        public Image getImagenI() {
                return (new ImageIcon(anima.getImagen()).getImage());
        }
}
    

