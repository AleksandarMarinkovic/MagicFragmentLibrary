//package com.hypercubesoft.mytestapplication.fragments;//package tv.sportssidekick.sportssidekick.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//
//import com.google.firebase.auth.FirebaseAuth;
//
//
//
///**
// * Created by Filip on 12/5/2016.
// * Copyright by Hypercube d.o.o.
// * www.hypercubesoft.com
// *
// * Base fragment that can cary argument with itself
// */
//
//public abstract class BaseFragment extends Fragment {
//
//    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";
//    private static final String TAG = "Base Fragment";
//
//
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    Object data;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//
//    protected boolean hasPrimaryArgument(){
//        return null!=getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
//    }
//
//    protected String getPrimaryArgument(){
//        return getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
//    }
//
//}
