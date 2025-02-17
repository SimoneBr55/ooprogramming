package org.nbicocchi.multithreading.lockinggranularity;

public class TestApp {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();

        ActorA a = new ActorA(sr);
        ActorB b = new ActorB(sr);
        ActorC c = new ActorC(sr);

        a.start();
        b.start();
        c.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.running = false;
        b.running = false;
        c.running = false;
    }
}
