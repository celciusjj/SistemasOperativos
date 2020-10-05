package com.juancarmona;
import java.util.ArrayList;

public class Main extends Thread{
    static Semaphore essem = new Semaphore(1, "essem");
    static ArrayList<Concurrency> lockeds = new ArrayList<>();
    static int contLector = 0;

    public static void main(String[] args)  {
        Escritor escritor1 = new Escritor("Escritor 1");
        Escritor escritor2 = new Escritor("Escritor 2");
        Escritor escritor3 = new Escritor("Escritor 3");
        Escritor escritor4 = new Escritor("Escritor 4");
        Lector lector1 = new Lector("lector1");
        Lector lector2 = new Lector("lector2");
        Lector lector3 = new Lector("lector3");
        Lector lector4 = new Lector("lector4");
        Lector lector5 = new Lector("lector5");

        try {
            lector1.start();
            //sleep(1);
            lector2.start();
            //sleep(1);
            lector3.start();
            //sleep(1);
            escritor1.start();


        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
