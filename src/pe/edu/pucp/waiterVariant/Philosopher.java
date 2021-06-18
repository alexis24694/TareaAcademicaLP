/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.waiterVariant;


/**
 *
 * @author alexis.leon
 */
public class Philosopher extends Thread{
    private Waiter waiter;
    private Fork leftFork, rightFork;
    private String status;
    private int philosopherId;
    
    public Philosopher(int philosopherId, Fork leftFork, Fork rightFork, Waiter waiter){
        this.philosopherId = philosopherId;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.waiter = waiter;
        think();
    }
    
    @Override
    public void run(){
        try{
            while(true){            
                action();
                sleep(2000);
            }
        }catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }   
    }
    
    @Override
    public String toString() {
        return "Filosofo " + (philosopherId + 1)+ ": " + status ;
    }
    
    public void action(){        
        waiter.pickUp(philosopherId, leftFork, rightFork);
        eat();
        waiter.putDown(philosopherId, leftFork, rightFork);
        think();
        
    }
    
    public void eat(){        
        try {
            setStatus("Comiendo");
            sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void think(){
        setStatus("Pensando");
    }

    /**
     * @return the rightFork
     */
    public Fork getRightFork() {
        return rightFork;
    }

    /**
     * @param rightFork the rightFork to set
     */
    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    /**
     * @return the leftFork
     */
    public Fork getLeftFork() {
        return leftFork;
    }

    /**
     * @param leftFork the leftFork to set
     */
    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.status = Status;
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

    /**
     * @return the waiter
     */
    public Waiter getWaiter() {
        return waiter;
    }

    /**
     * @param waiter the waiter to set
     */
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
