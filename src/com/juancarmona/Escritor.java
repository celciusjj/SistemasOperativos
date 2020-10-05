package com.juancarmona;

import java.util.Random;

import static com.juancarmona.Main.essem;

public class Escritor extends Thread{
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

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
