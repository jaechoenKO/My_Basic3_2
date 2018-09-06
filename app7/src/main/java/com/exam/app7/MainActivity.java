package com.exam.app7;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;

    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바 대신에 툴바가 위에 있다.
        toolbar = findViewById(R.id.toolbar);

        // 툴바를 액션바로 셋팅.
        setSupportActionBar(toolbar);

        // 액션바 가져오기
        ActionBar actionBar = getSupportActionBar();
        // 기존 액션바 title 없애기
        actionBar.setDisplayShowTitleEnabled(false);

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();

        // 프래그먼트01로 화면 지정
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment01).commit();

        // tab layout 객체를 찾아온다.
        TabLayout tabs = findViewById(R.id.tabs);
        // tab 추가
        tabs.addTab(tabs.newTab().setText("tab menu 1"));
        tabs.addTab(tabs.newTab().setText("tab menu 2"));
        tabs.addTab(tabs.newTab().setText("tab menu 3"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;

                if(position == 0){
                    selected = fragment01;
                }else if(position == 1){
                    selected = fragment02;
                }else if(position == 2){
                    selected = fragment03;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
