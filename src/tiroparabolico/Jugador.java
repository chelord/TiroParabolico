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
    public Jugador(int posX, int posY, int vel) {
        super(posX, posY);
        this.vel = vel;
        Image jugador1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo1.png"));
        Image jugador2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo2.png"));
        Image jugador3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo3.png"));
        Image jugador4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo4.png"));
        Image jugador5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo5.png"));
        Image jugador6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images/malo6.png"));

        anima.sumaCuadro(jugador1, 100);
        anima.sumaCuadro(jugador2, 100);
        anima.sumaCuadro(jugador3, 100);
        anima.sumaCuadro(jugador4, 100);
        anima.sumaCuadro(jugador5, 100);
        anima.sumaCuadro(jugador6, 100);

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
