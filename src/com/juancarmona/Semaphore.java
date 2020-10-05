package com.juancarmona;

public class Semaphore {
    private int counter;
    private boolean isLocked = false;
    String id;
    int contador = 0;

    Semaphore(int counter, String id){
        this.setCounter(counter);
        this.id = id;
    }

    void waitFunction(){
        setCounter(getCounter() - 1);
        System.out.println(id + ": " +getCounter());
        System.out.println("--------------------------------");
        if(getCounter() < 0){
            setLocked(true);
        }
    }

    void signalFunction(){
        setCounter(getCounter() + 1);
        System.out.println(id + ": " +getCounter() + " Signal");
        System.out.println("--------------------------------");
        if(getCounter() <= 0){
            for (int i = 0; i < Main.threads.size(); i++) {
                Main.threads.get(i).continueThread();
                Main.threads.remove(Main.threads.get(i));
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

