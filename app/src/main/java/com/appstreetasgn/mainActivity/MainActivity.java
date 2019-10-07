package com.appstreetasgn.mainActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.appstreetasgn.R;
import com.appstreetasgn.utility.ConnectivityUtils;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainActivityPresenter {

    //used for logging
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
        }
    }
}
