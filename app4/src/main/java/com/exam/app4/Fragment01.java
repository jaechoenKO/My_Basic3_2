package com.exam.app4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment01 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment01, container, false);

        // rootView 안에 뷰 그룹이 있기 때문에 rootView에서 아이디 값을 찾는다.
        Button btn = rootView.findViewById(R.id.btn01);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * 프래그먼트 선언이 MainActivity에 있기에 MainAcitivty를 가져와야한다.
                 * getActivity() : 프로그래먼트를 포함하는 액티비티 객체를 리턴하는 객체
                **/
                MainActivity mainActivity = (MainActivity) getActivity();
                // 바꿀 엑티비티. 파라미터로 index 값을 넘김
                mainActivity.onFragmentChanged(0);
            }
        });

        return rootView;
    }
}
