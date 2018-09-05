package com.exam.app4;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Fragment01 fragment01;
    Fragment02 fragment02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml을 이용한 프로그래먼트 추가, 프래그먼트 얻어오기. 캐스팅을 해준다. getSupportFragmentManager() : 3.0 이전 버전도 지원하는 메소드
        fragment01 = (Fragment01) getSupportFragmentManager().findFragmentById(R.id.frag01);
        // getFragmentManager() : 기존의 이전 버전을 지원하지 않음. import도 v4가 아닌 app에 있다.
//        fragment01 = (Fragment01)getFragmentManager().findFragmentById(R.id.frag01);

        // 자바 코드를 통한 프래그먼트 추가
        fragment02 = new Fragment02();

    }


    /**
     * 프래그먼트 교체를 관여하는 메소드.
     * **/
    // 프로그래먼트 액티비티는 메인엑티비티에서 관여한다.
    public void onFragmentChanged(int index){

        // 프로그래먼트 화면 전환
        if(index == 0){
            // beginTransaction() : 프로그래먼트를 교체할때 필요한 객체 commit() : 확실하게 해주겠다.
            getSupportFragmentManager().beginTransaction().replace(R.id.parent_view, fragment02).commit();
        }else if(index == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.parent_view, fragment01).commit();
        }

    }


}
