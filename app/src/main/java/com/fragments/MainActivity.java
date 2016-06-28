package com.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean flag = false;
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragment1 = new Fragment1();
            fragment2 = new Fragment2();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.container, fragment1, Fragment1.class.getName())
                    .add(R.id.container, fragment2, Fragment2.class.getName())
                    .show(fragment1)
                    .hide(fragment2)
                    .commit();
        } else {
            fragment1 = (Fragment1) getSupportFragmentManager().findFragmentByTag(Fragment1.class.getName());
            fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag(Fragment2.class.getName());
        }

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    showFragment(fragment1);
                } else {
                    showFragment(fragment2);
                }
                Log.i("Flag", flag + "");
                flag = !flag;
            }
        });
    }

    /**
     * show fragment
     * @param fragment the fragment to show
     */
    public void showFragment(Fragment fragment) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (!fragments.get(i).isHidden()) {
                transaction.hide(fragments.get(i));
                break;
            }
        }
        transaction.show(fragment).commit();
    }


}
