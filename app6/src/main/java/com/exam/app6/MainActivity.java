package com.exam.app6;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelection {

    ListFragment listFragment;
    ImageFragment imageFragment;

    int[] imgs = {android.R.drawable.sym_def_app_icon, android.R.drawable.btn_star_big_off
            ,android.R.drawable.btn_star_big_on};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액티비티 값 전달. 프래그먼트 매니저가 필요.
        FragmentManager fragmentManager = getSupportFragmentManager();
        listFragment = (ListFragment) fragmentManager.findFragmentById(R.id.list_fm);
        imageFragment = (ImageFragment) fragmentManager.findFragmentById(R.id.img_fm);

    }

    @Override
    public void onImageSelect(int postion) {

        // 해당 포지션에 이미지 프래그먼트에 할당.
        imageFragment.setImageView(imgs[postion]);
    }
}
