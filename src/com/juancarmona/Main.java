package com.juancarmona;
import java.util.ArrayList;

public class Main {
    static Semaphore essem = new Semaphore(1, "essem");
    static ArrayList<Escritor> threads = new ArrayList<>();
    static int contLector = 0;

    public static void main(String[] args) {
        Escritor escritor1 = new Escritor();
        Lector lector1 = new Lector();
        Lector lector2 = new Lector();
        Lector lector3 = new Lector();
        Lector lector4 = new Lector();
        //threads.add(lector1);
        //threads.add(lector2);
        //threads.add(lector3);
        threads.add(escritor1);

	    lector1.start();
	    lector2.start();
	    lector3.start();
        escritor1.start();
        //escritor1.writer();
    }
}
