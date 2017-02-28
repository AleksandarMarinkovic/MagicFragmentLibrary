package com.hypercubesoft.magicfragmentlibrary;


/**
 * Created by Filip on 12/5/2016.
 * Copyright by Hypercube d.o.o.
 * www.hypercubesoft.com
 */

public class FragmentEvent {

    public Class getType() {
        return classType;
    }

    public void setType(Class type) {
        this.classType = type;
    }

    Class classType;

    String id;

    /**
     *
     * @param type Fragment or any class
     */
    public FragmentEvent(Class type) {
        id = null;
        this.classType = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
