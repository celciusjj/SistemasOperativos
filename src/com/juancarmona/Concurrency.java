package com.juancarmona;

public class Concurrency extends Thread{

    public Object lock = this;
    /*
    private boolean pause = false;


    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }


    public void pause()
    {
        setPause(true);
    }

    public void rerun()
    {
        setPause(false);
    }
    */

    /**
     * Metodo encargado de notificar al Hilo que siga su ejecución
     */
    public void continueThread ()
    {
        synchronized (lock)
        {
            lock.notify();
            //rerun();
        }
    }

    /**
     * Metodo encargado de hacer esperar el hilo.
     */
    void pauseThread() {
        synchronized (lock)
        {
            try {
                lock.wait();
                //pause();
            }catch (InterruptedException ex){
                System.out.println(ex);
            }
        }
    }
}
