package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.essem;

public class Escritor extends Concurrency{

    public void run(){
        writer();
    }

    void writer(){
        essem.waitFunction();

        if(essem.isLocked()) {
            pauseThread();
        }
        writingDisk();
        essem.signalFunction();
    }

    void writingDisk(){
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(5000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
