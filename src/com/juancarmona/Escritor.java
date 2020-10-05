package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.essem;
import static com.juancarmona.Main.lockeds;

public class Escritor extends Concurrency{

    String id;

    Escritor(String id){
        this.id = id;
    }

    public void run(){
        writer();
    }

    void writer(){
        //while(true) {
            essem.waitFunction();
            if (essem.isLocked()) {
                lockeds.add(this);
                System.out.println("Entra a bloquear " + id);
                pauseThread();
                System.out.println("Sale de bloqueados " + id);
            }
            writingDisk();
            essem.signalFunction();
       // }
    }

    /**
     * Este metodo representa la SC de el escritor, donde escribe sobre el disco.
     */
    void writingDisk(){
        try {
            System.out.println("Seccion critica "+id);
            Random r = new Random();
            Thread.sleep(r.nextInt(20000));
            //Thread.sleep(10000);
            System.out.println("Termina ejecucion " + id);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
