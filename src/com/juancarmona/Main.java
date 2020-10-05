package com.juancarmona;
import java.util.ArrayList;

public class Main extends Thread{
    static Semaphore essem = new Semaphore(1, "essem");
    static ArrayList<Concurrency> threads = new ArrayList<>();
    static int contLector = 0;

    public static void main(String[] args) throws InterruptedException {
        Escritor escritor1 = new Escritor();
        Escritor escritor2 = new Escritor();
        Lector lector1 = new Lector();
        Lector lector2 = new Lector();
        Lector lector3 = new Lector();
        Lector lector4 = new Lector();

        threads.add(lector1);
        threads.add(lector2);
        threads.add(lector3);
        threads.add(escritor1);
        threads.add(lector4);
        threads.add(escritor2);


	    lector1.start();
	    sleep(10000);
	    lector2.start();
        sleep(10000);
	    lector3.start();
        sleep(10000);
        escritor1.start();
        lector4.start();
        escritor2.start();
    }
}
