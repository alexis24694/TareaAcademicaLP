/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.waiterVariant;

import javax.swing.DefaultListModel;

/**
 *
 * @author alexis.leon
 */
public class DiningTable extends Thread{
    private DefaultListModel forks;
    private DefaultListModel philosophers;
    private Waiter waiter;
    private final int size = 5;

    public DiningTable() {
        
        waiter = new Waiter();
        
        this.forks = new DefaultListModel<>();
        for (int i = 0; i < size; i++){
            forks.addElement(new Fork());
        }
        
        this.philosophers = new DefaultListModel<>();
        
        for (int i = 0; i < size; i++){
            Philosopher philosopher = new Philosopher(i, ((Fork)forks.get(i)), ((Fork)forks.get((i+1) % size)), waiter);            
            philosophers.addElement(philosopher);            
        }
    }
    
    @Override
    public void run(){
        for (int i = 0; i < size; i++){
            ((Philosopher)philosophers.get(i)).start();            
        }
    }   

    /**
     * @return the forks
     */
    public DefaultListModel getForks() {
        return forks;
    }

    /**
     * @param forks the forks to set
     */
    public void setForks(DefaultListModel forks) {
        this.forks = forks;
    }

    /**
     * @return the philosophers
     */
    public DefaultListModel getPhilosophers() {
        return philosophers;
    }

    /**
     * @param philosophers the philosophers to set
     */
    public void setPhilosophers(DefaultListModel philosophers) {
        this.philosophers = philosophers;
    }
}
