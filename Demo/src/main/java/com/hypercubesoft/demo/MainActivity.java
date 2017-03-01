package com.hypercubesoft.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//import com.hypercubesoft.magicfragmentlibrary.FragmentOrganizer;
import com.hypercubesoft.magicfragmentlibrary.FragmentOrganizer;
import com.hypercubesoft.demo.fragments.BlankFragment;
import com.hypercubesoft.demo.fragments.BlankFragment1;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layout;
    FragmentOrganizer fragmentOrganizer;
    Button button2;
    boolean mybulean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.hypercubesoft.demo.R.layout.activity_main);
        fragmentOrganizer = new FragmentOrganizer(getSupportFragmentManager(), BlankFragment.class);
        layout = (LinearLayout) findViewById(com.hypercubesoft.demo.R.id.wraper);
        mybulean = false;
        ArrayList<Class> leftContainerFragments = new ArrayList<>();
        leftContainerFragments.add(BlankFragment.class);
        leftContainerFragments.add(BlankFragment1.class);
        fragmentOrganizer.setUpContainer(com.hypercubesoft.demo.R.id.wraper, leftContainerFragments);
        button2 = (Button) findViewById(com.hypercubesoft.demo.R.id.button2);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (isOpen())
            fragmentOrganizer.putFragment(BlankFragment.class);
        else
            fragmentOrganizer.putFragment(BlankFragment1.class);


    }

    private boolean isOpen() {
        if (mybulean) {
            mybulean = false;
            return true;
        } else {
            mybulean = true;
            return false;
        }
    }
}
