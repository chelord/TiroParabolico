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

public class Jugador extends Base{
    private int vel;
    
    /**
     * Metodo constructor usado para crear el objeto Malo
     * @param posX es la <code>posicion en x</code> del objeto.
     * @param posY es la <code>posicion en y</code> del objeto.
     * @param vel es la <code>velocidad</code> del objeto.
     * @param conteo es un <code>contador</code> del objeto.
     */
    public Jugador(int posX, int posY, int vel,Image imagen) {
        super(posX,posY,imagen);
        vel = 1;
    }
 
    /**
    * Metodo de acceso que regresa la velocidad del objeto 
    * @return vel es la <code>velocidad</code> del objeto.
    */
    public int getVel() {
        return vel;
    }
    
    /**
    * Metodo modificador usado para cambiar la velocidad del objeto 
    * @param velocidad es la <code>velocidad</code> del objeto.
    */
    public void setVel(int velocidad) {
        vel = velocidad;
    }
    
}
