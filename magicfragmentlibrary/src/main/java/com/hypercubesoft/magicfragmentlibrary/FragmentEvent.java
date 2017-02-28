package com.hypercubesoft.magicfragmentlibrary;




/**
 * Created by Filip on 12/5/2016.
 * Copyright by Hypercube d.o.o.
 * www.hypercubesoft.com
 */

public class FragmentEvent extends BusEvent {

    public Class getType() {
        return classType;
    }

    public void setType(Class type) {
        this.classType = type;
    }

    Class classType;


    public FragmentEvent(Class type) {
        super(null);
        this.classType = type;
    }
}
