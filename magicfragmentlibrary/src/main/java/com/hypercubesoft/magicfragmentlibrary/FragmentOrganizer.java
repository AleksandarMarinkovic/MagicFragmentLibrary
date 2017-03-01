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
     * Primary tag
     */
    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";

    /**
     * constructor
     * @param fragmentManager fragment manager
     * @param fragment   First fragment in stack.  Fragment is not active
     */
    public FragmentOrganizer(FragmentManager fragmentManager, Class fragment) {
        super(fragmentManager);
        containersMap = new SparseArray<>();
        this.initialFragment = fragment;


    }

    /**
     * @return Returns the currently active fragment
     */
    public Fragment getOpenFragment() {
        String tag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        return fragmentManager.findFragmentByTag(tag);
    }

    /**
     * Open fragment
     *
     * @param fragmentclass put Class and if fragment start
     * @return return this FragmentEvent without id;
     */
    public FragmentEvent putFragment(Class fragmentclass) {
        FragmentEvent event = new FragmentEvent(fragmentclass);
        Bundle arguments = new Bundle();
        arguments.putString(PRIMARY_ARG_TAG, event.getId());
        openFragment(createFragment(event.getType()), arguments, getFragmentContainer(event.getType()));
        return event;
    }

    /**
     * Open fragment
     *
     * @param event FragmentEvent
     * @param id    set id In FragmentEvent and start Fragment
     * @return return this FragmentEvent with id;
     */
    public FragmentEvent putFragment(FragmentEvent event, String id) {
        event.setId(id);
        Bundle arguments = new Bundle();
        arguments.putString(PRIMARY_ARG_TAG, id);
        openFragment(createFragment(event.getType()), arguments, getFragmentContainer(event.getType()));
        return event;
    }

    /**
     * Manually Back Navigation
     * Pop the top state off the back stack.
     *
     * @return Returns true if it is not the first fragment and pop fragment .
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
     * Get Fragment Container
     *
     * @param fragment fragment
     * @return returns id of the Container if there is exists a given fragment
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
     * @param containerResourceId Container id,This can be any View,Layout or Fragment.
     * @param containerFragments  Fragment list,All fragments in a container to put here
     */
    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments) {
        setUpContainer(containerResourceId, containerFragments, false);
    }

    /**
     * @param containerResourceId Container id, this can be any View,Layout or Fragment
     * @param containerFragments  Fragment list. All fragments in a container to put here.
     * @param withoutBackStack    Flag if true fragment will not create a stack for these fragments.
     */
    public void setUpContainer(int containerResourceId, ArrayList<Class> containerFragments, boolean withoutBackStack) {
        containersMap.put(containerResourceId, containerFragments);
        if (withoutBackStack) {
            containersWithoutBackStack.add(containerResourceId);
        }
    }
}
