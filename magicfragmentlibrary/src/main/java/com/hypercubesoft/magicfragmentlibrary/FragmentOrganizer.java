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
    /**
     * Tag
     */
    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";

    /**
     * constructor
     * @param fragmentManager fragment menager
     * @param fragment first fragment in stack
     */
    public FragmentOrganizer(FragmentManager fragmentManager, Class fragment) {
        super(fragmentManager);
        containersMap = new SparseArray<>();
        this.initialFragment = fragment;


    }

    /**
     *
     * @return Return open Fragment
     */
    public Fragment getOpenFragment(){
        String tag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() -1).getName();
        return fragmentManager.findFragmentByTag(tag);
    }

    /**
     * Start fragment put in stack
     * @param fragmentclass put Class and if fragment start
     */
    public void putFragment(Class fragmentclass) {
        FragmentEvent event = new FragmentEvent(fragmentclass);
        Bundle arguments = new Bundle();
        arguments.putString(PRIMARY_ARG_TAG, event.getId());
        openFragment(createFragment(event.getType()), arguments, getFragmentContainer(event.getType()));
    }

    /**
     *
     * @param event  FragmentEvent
     * @param id   set id In FragmentEvent and start Fragment
     * @return  return this FragmentEvent with id;
     */
    public FragmentEvent putFragment(FragmentEvent event, String id) {
        event.setId(id);
        Bundle arguments = new Bundle();
        arguments.putString(PRIMARY_ARG_TAG, id);
        openFragment(createFragment(event.getType()), arguments, getFragmentContainer(event.getType()));
        return event;
    }

    /**
     *
     * @return true or false
     * if last fragment in stack false
     */
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

    /**
     *
     * @param fragment  fragment
     * @return return key or -1
     */
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



    /**
     *
     * @param containerResourceId Container id
     * @param containerFragments Fragment list
     */
    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments) {
        setUpContainer(containerResourceId, containerFragments, false);
    }

    /**
     *
     * @param containerResourceId Container id
     * @param containerFragments Fragment list
     * @param withoutBackStack if true without back stack
     */
    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments, boolean withoutBackStack) {
        containersMap.put(containerResourceId, containerFragments);
        if (withoutBackStack) {
            containersWithoutBackStack.add(containerResourceId);
        }
    }
}
