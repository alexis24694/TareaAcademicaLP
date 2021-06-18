/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.waiterVariant;


/**
 *
 * @author alexi
 */
public class Waiter {
    public synchronized void pickUp(int philosopherId, Fork left, Fork right){
        try {
            
            
            if (left.getPhilosopherId() != -1 || right.getPhilosopherId() != -1){
                wait();
            }
            left.pickUp(philosopherId);
            right.pickUp(philosopherId);
            
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public synchronized void putDown(int philosopherId, Fork left, Fork right){
        left.putDown();
        right.putDown();
        notify();
    }
}
