/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author alexis.leon
 */
public class FormUpdater extends Thread{
    JFrame jFrame;
    public FormUpdater(JFrame jFrame){
        this.jFrame = jFrame;
    }
    public void run(){
        while (true){
            try {
                jFrame.repaint();
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(formMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
