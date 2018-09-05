package com.exam.app5;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMenu01;
    Button btnMenu02;
    Button btnMenu03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu01 = findViewById(R.id.btn_menu01);
        btnMenu02 = findViewById(R.id.btn_menu02);
        btnMenu03 = findViewById(R.id.btn_menu03);

        btnMenu01.setOnClickListener(onClickListener);
        btnMenu02.setOnClickListener(onClickListener);
        btnMenu03.setOnClickListener(onClickListener);

        addPage01();

    }


    private void addPage01(){

        Page01 page01 = new Page01();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_linear, page01).commit();

    }

    private void addPage02(){

        Page02 page02 = new Page02();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_linear, page02).commit();

    }

    private void addPage03(){

        Page03 page03 = new Page03();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.right_linear, page03).commit();

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.btn_menu01:
                    addPage01();
                    break;
                case R.id.btn_menu02:
                    addPage02();
                    break;
                case R.id.btn_menu03:
                    addPage03();
                    break;
                default:
                    break;
            }

        }
    };

}
