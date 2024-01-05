package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimulationEngine {
    private List<Simulation> simulations;
    private List<Thread> threads = new ArrayList<>();

    private static Integer stop_threads_count = 0;

    private static final Object obj = new Object();
    public SimulationEngine(List<Simulation> simulations){
        this.simulations = simulations;
    }

    public void awaitthreadend(Thread JD){
        JD.notify();
    }
    public void awaitSimulationEnd(ExecutorService ex) throws InterruptedException{
        ex.shutdown();

        try {
            ex.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch(InterruptedException inter){
            inter.printStackTrace();
        }
    }

    public synchronized void runSync() throws InterruptedException{
        for(Simulation S: this.simulations){
            Thread watek = new Thread(S);
            watek.start();
            threads.add(watek);
        }
        System.out.println("Rozmiar threads:");
        System.out.println(this.threads.size());
        try {
            for (Thread W : this.threads) {
                W.join();
            }
        }
        catch(InterruptedException X){
            X.printStackTrace();
        }
    }

    public void pool() throws InterruptedException{
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(Simulation S: this.simulations){
            executor.submit(S);
        }
        awaitSimulationEnd(executor);
    }

}
