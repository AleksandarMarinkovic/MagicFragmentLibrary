package com.hypercubesoft.magicfragmentlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 12/5/2016.
 * Copyright by Hypercube d.o.o.
 * www.hypercubesoft.com
 */

public class FragmentOrganizer extends AbstractFragmentOrganizer {

    private SparseArray<List<Class>> containersMap;
    private Class initialFragment;
    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";
    public FragmentOrganizer(FragmentManager fragmentManager, Class fragment) {
        super(fragmentManager);
        containersMap = new SparseArray<>();
        this.initialFragment = fragment;


    }

    public void putFragment(Class fragmentclass) {
        FragmentEvent event = new FragmentEvent(fragmentclass);
        Bundle arguments = new Bundle();
        arguments.putString(PRIMARY_ARG_TAG, event.getId());
        openFragment(createFragment(event.getType()), arguments, getFragmentContainer(event.getType()));
    }

    @Override
    public boolean handleBackNavigation() {
        Fragment fragment = getOpenFragment();
        if (fragment.getClass().equals(initialFragment)) {
            return false;
        } else {
            fragmentManager.popBackStack();
            return true;
        }
    }


    protected int getFragmentContainer(Class fragment) {
        for (int i = 0; i < containersMap.size(); i++) {
            int key = containersMap.keyAt(i);
            List<Class> fragments = containersMap.get(key);
            for (Class f : fragments) {
                if (f.equals(fragment)) {
                    return key;
                }
            }
        }
        return -1;
    }

    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments) {
        setUpContainer(containerResourceId, containerFragments, false);
    }

    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments, boolean withoutBackStack) {
        containersMap.put(containerResourceId, containerFragments);
        if (withoutBackStack) {
            containersWithoutBackStack.add(containerResourceId);
        }
    }
}
