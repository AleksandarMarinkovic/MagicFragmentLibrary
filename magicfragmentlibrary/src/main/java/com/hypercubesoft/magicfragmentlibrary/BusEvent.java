package com.hypercubesoft.magicfragmentlibrary;

/**
 * Created by Aleksandar Marinkovic on 28-Feb-17.
 * Copyright by Hypercube d.o.o.
 * www.hypercubesoft.com
 */
public class BusEvent {

    protected String id;

    public BusEvent(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

