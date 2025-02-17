package org.nbicocchi.multithreading.lockinggranularity;

public class ActorB extends Thread {
    SharedResource sr;
    boolean running = true;

    public ActorB(SharedResource sr) {
        super();
        this.sr = sr;
    }

    @Override
    public void run() {
        while (running) {
            sr.B();
        }
    }
}
