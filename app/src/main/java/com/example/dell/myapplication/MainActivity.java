package com.example.dell.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.myapplication.model.ToaatContentMaker;
import com.example.dell.myapplication.presenter.persernter;
import com.example.dell.myapplication.view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private Button mBtnToast;
    private com.example.dell.myapplication.presenter.persernter persernter;
    private Button mBtnDay;
    private Button mBtnNight;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        persernter = new persernter(this, new ToaatContentMaker());
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(MainActivity.this, "" + content, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mBtnToast = (Button) findViewById(R.id.btn_toast);

        mBtnToast.setOnClickListener(this);
        mBtnDay = (Button) findViewById(R.id.btn_day);
        mBtnDay.setOnClickListener(this);
        mBtnNight = (Button) findViewById(R.id.btn_night);
        mBtnNight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                persernter.clickButton();
                break;
            case R.id.btn_day:
                setNightMode();
                break;
            case R.id.btn_night:
                break;
        }
    }

    private void setNightMode() {
        //  获取当前模式
        int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (mode == Configuration.UI_MODE_NIGHT_YES) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();
    }

}
