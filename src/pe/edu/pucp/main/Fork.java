/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.main;

import java.util.concurrent.Semaphore;

/**
 *
 * @author alexi
 */
public class Fork {
    private Semaphore semaphore;
    private int philosopherId;
    
    public Fork(){
        semaphore = new Semaphore(1);
        philosopherId = -1;
    }
    
    public boolean pickUp() {
        return semaphore.tryAcquire();
    }

    public void putDown() {
        semaphore.release();
        philosopherId = -1;
    }
    
    @Override
    public String toString() {
        return philosopherId > 0 ? "Usado por " + (philosopherId + 1) : "Disponible";
    }
    

    /**
     * @return the semaphore
     */
    public Semaphore getSemaphore() {
        return semaphore;
    }

    /**
     * @param semaphore the semaphore to set
     */
    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * @return the philosopherId
     */
    public int getPhilosopherId() {
        return philosopherId;
    }

    /**
     * @param philosopherId the philosopherId to set
     */
    public void setPhilosopherId(int philosopherId) {
        this.philosopherId = philosopherId;
    }
    
    
}
