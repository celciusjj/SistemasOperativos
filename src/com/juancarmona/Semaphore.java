package com.juancarmona;

public class Semaphore {
    private int counter;
    private boolean isLocked = false;
    String id;

    Semaphore(int counter, String id){
        this.setCounter(counter);
        this.id = id;
    }

    void waitFunction(){
        setCounter(getCounter() - 1);
        if(getCounter() < 0){
            setLocked(true);
        }
    }

    void signalFunction(){
        setCounter(getCounter() + 1);
        if(getCounter() <= 0){
            if(isLocked){
                for (int i = 0; i < Main.threads.size(); i++){
                    if(Main.threads.get(i).isPause()){
                        System.out.println("enta aqui");
                        Main.threads.get(i).continueThread();
                    }
                }
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

