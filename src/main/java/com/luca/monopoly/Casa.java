package com.luca.monopoly;

public class Casa {
    private int numeroCase = 32;
    private int numeroAlberghi = 12; 
    private boolean isAlbergo;
    
    public Casa(boolean isAlbergo) {
        this.isAlbergo = isAlbergo; 
    }

    public int getNumeroCase() {
        return numeroCase; 
    }

    public int getNumeroAlberghi() {
        return numeroAlberghi; 
    }

    public boolean isAlbergo() {
        return isAlbergo; 
    }
}
