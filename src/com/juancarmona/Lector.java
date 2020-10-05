package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.*;

public class Lector extends Concurrency {
    Semaphore x;
    String id;

    Lector(String id){
      x = new Semaphore(1, "x");
      this.id = id;
    }

    public void run(){
        reader();
    }

    void reader(){
        //while(true){
        x.waitFunction();
        contLector++;
        //System.out.println("contLector arriba: " +contLector);
        if(contLector == 1){
            essem.waitFunction();
            if(essem.isLocked()){
                threads.add(this);
                pauseThread();
            }
        }
        x.signalFunction();
        readingDisk();
        x.waitFunction();
        contLector--;
        if(contLector == 0){
            essem.signalFunction();
            x.signalFunction();
        }
    }

    void readingDisk() {
        try {
            System.out.println("SC " + id) ;
            Random r = new Random();
            //Thread.sleep(r.nextInt(20000));
            Thread.sleep(10000);
            System.out.println("Termina ejecucion "+ id);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
