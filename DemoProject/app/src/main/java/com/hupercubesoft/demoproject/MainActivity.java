package com.hupercubesoft.demoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hupercubesoft.demoproject.fragments.BlankFragment;
import com.hupercubesoft.demoproject.fragments.BlankFragment1;
import com.hypercubesoft.magicfragmentlibrary.FragmentOrganizer;

import java.util.ArrayList;

//import com.hypercubesoft.magicfragmentlibrary.FragmentOrganizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layout;
    FragmentOrganizer fragmentOrganizer;
    Button button2;
    boolean mybulean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentOrganizer = new FragmentOrganizer(getSupportFragmentManager(), BlankFragment.class);
        layout = (LinearLayout) findViewById(R.id.wraper);
        mybulean = false;
        ArrayList<Class> leftContainerFragments = new ArrayList<>();
        leftContainerFragments.add(BlankFragment.class);
        leftContainerFragments.add(BlankFragment1.class);
        fragmentOrganizer.setUpContainer(R.id.wraper, leftContainerFragments);
        button2 = (Button) findViewById(R.id.button2);
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
