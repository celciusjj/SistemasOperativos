package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.contLector;
import static com.juancarmona.Main.essem;

public class Lector extends Concurrency {
    Semaphore x;

    Lector(){
      x = new Semaphore(1, "x");
    }

    public void run(){
        reader();
    }

    void reader(){
        //while(true){
        x.waitFunction();
        contLector++;
        if(contLector == 1){
            essem.waitFunction();
            if(essem.isLocked()){
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
            Random r = new Random();
            Thread.sleep(r.nextInt(20000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
