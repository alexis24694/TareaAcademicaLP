/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.main;

/**
 *
 * @author alexi
 */
public class Philosopher extends Thread{
    private Fork leftFork, rightFork;
    private String status;
    private int philosopherId;
    
    public Philosopher(int philosopherId, Fork leftFork, Fork rightFork){
        this.philosopherId = philosopherId;
        this.leftFork = leftFork;
        this.rightFork = rightFork;        
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
        if (leftFork.pickUp()){
            leftFork.setPhilosopherId(getPhilosopherId());
        }
        if (rightFork.pickUp()){
            rightFork.setPhilosopherId(getPhilosopherId());
        }
        if (leftFork.getPhilosopherId() == getPhilosopherId() && leftFork.getPhilosopherId() == getPhilosopherId()
                && rightFork.getPhilosopherId() == getPhilosopherId() && rightFork.getPhilosopherId() == getPhilosopherId()){
            eat();
            leftFork.putDown();
            rightFork.putDown();
            think();
        }else{
            think();
        }
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
}
