package com.juancarmona;

public class Concurrency extends Thread{

    public Object lock = this;
    private boolean pause = false;


    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    /*
    public void pause()
    {
        setPause(true);
    }

    public void rerun()
    {
        setPause(false);
    }
    */


    public void continueThread ()
    {
        synchronized (lock)
        {
            System.out.println("entra al continue");
            lock.notify();
            //rerun();
        }
    }

    void pauseThread() {
        synchronized (lock)
        {
            try {
                System.out.println("entra a pausar");
                lock.wait();
                //pause();
            }catch (InterruptedException ex){
                System.out.println(ex);
            }
        }
    }
}
