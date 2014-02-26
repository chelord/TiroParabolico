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

      import java.awt.Image;
      import java.awt.Toolkit;

public class Bola extends Base{
    
        public Bola(int posX,int posY){
	super(posX,posY);	
        Image bola1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/bueno1.png"));
        Image bola2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/bueno2.png"));
        
        anima.sumaCuadro(bola1, 100);
        anima.sumaCuadro(bola2, 100);
 
	}
    //Variables estáticas de tipo string
    private static final String PAUSADO = "PAUSADO";
    private static final String DESAPARECE = "DESAPARECE";
    private int velocidadIniX;
    private int velocidadIniY;
    
    /**
    * Metodo de acceso que regresa el string "Pausado" del objeto 
    * @return PAUSADO es el <code>string "Pausado"</code> del objeto.
    */
    public static String getPAUSADO(){
        return PAUSADO;
    }
    
    /**
    * Metodo de acceso que regresa el string "Desaparece" del objeto 
    * @return DESAPARECE es el <code>string "Desaparece"</code> del objeto.
    */
    public static String getDesaparece(){
        return DESAPARECE;
    }
    
    /**
    * Metodo de acceso que regresa el int velocidadX del objeto 
    * @return velocidadX es la velocidad en X del objeto. 
    */
    public int getVelocidadInicialX(){
        return velocidadIniX;
    }
    
    /**
    * Metodo de acceso que modifica el int velocidadX del objeto 
    * @param vel es la velocidad en x del objeto
    */
    public void setVelocidadInicialX(int vel){
        velocidadIniX = vel;
    }
    
        /**
    * Metodo de acceso que regresa el int velocidadX del objeto 
    * @return velocidadX es la velocidad en Y del objeto. 
    */
    public int getVelocidadInicialY(){
        return velocidadIniY;
    }
    
    /**
    * Metodo de acceso que modifica el int velocidadX del objeto 
    * @param vel es la velocidad en Y del objeto
    */
    public void setVelocidadInicialY(int vel){
        velocidadIniY = vel;
    }
    
    /**
    * Metodo de acceso que regresa el int velocidadX del objeto 
    * @param vel es la velocidad en Y del objeto
    */
    public int getVelocidadX(){
        return velocidadIniX;
    }
    
    
}
