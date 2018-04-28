package com.example.dell.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.myapplication.model.ToaatContentMaker;
import com.example.dell.myapplication.presenter.persernter;
import com.example.dell.myapplication.view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private Button mBtnToast;
    private com.example.dell.myapplication.presenter.persernter persernter;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        persernter = new persernter(this, new ToaatContentMaker());
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(MainActivity.this, "" + content, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mBtnToast = (Button) findViewById(R.id.btn_toast);

        mBtnToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toast:
                persernter.clickButton();
                break;
        }
    }
}
