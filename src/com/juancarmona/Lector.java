package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.contLector;
import static com.juancarmona.Main.essem;

public class Lector extends Thread {
    Semaphore x;
    public Object lock = this;
    private boolean pause = true;

    public void pause()
    {
        setPause(true);
    }

    public void rerun()
    {
        setPause(false);
    }

    public void continueThread ()
    {
        synchronized (lock)
        {
            lock.notifyAll();
        }
    }

    private void pauseThread () {
        synchronized (lock)
        {
            if (isPause()) {
                try {
                    lock.wait();
                    pause();
                }catch (InterruptedException ex){
                    System.out.println(ex);
                }
            }
        }
    }


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

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
