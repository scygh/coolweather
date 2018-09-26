package com.coolweather.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment getFragment();
    protected int getLayoutResId(){
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.main_framelayout);
        if(fragment==null) {
            fragment = getFragment();
            fm.beginTransaction()
                    .add(R.id.main_framelayout, fragment)
                    .commit();
        }
    }
}
