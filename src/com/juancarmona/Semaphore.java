package com.juancarmona;

public class Semaphore {
    private int counter;
    private boolean isLocked = false;
    String id;

    Semaphore(int counter, String id){
        this.setCounter(counter);
        this.id = id;
    }

    /**
     * Metodo wait
     */
    void waitFunction(){
        setCounter(getCounter() - 1);
        System.out.println(id + ": " +getCounter()+ " Wait");
        System.out.println("--------------------------------");
        if(getCounter() < 0){
            setLocked(true);
        }
    }

    /**
     * Metodo signal de un semaforo, cuando el contador <= 0 se reanuda el primer hilo en bloqueados
     * y se elimina de la lista de bloqueados
     */
    void signalFunction(){
        setCounter(getCounter() + 1);
        System.out.println(id + ": " +getCounter() + " Signal");
        System.out.println("--------------------------------");
        if(getCounter() <= 0){
            System.out.println("entraa aquiii");
            for (int i = 0; i < Main.lockeds.size(); i++) {
                Main.lockeds.get(i).continueThread();
                Main.lockeds.remove(Main.lockeds.get(i));
                break;
            }
            setLocked(false);
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}

