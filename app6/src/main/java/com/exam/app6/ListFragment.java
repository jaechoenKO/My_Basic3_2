package com.exam.app6;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    String[] title = {"image01", "image02", "image03"};

    /**
     * 인터페이스 구현
     * 나중에 ImageSelection을 구현해서 사용 할 수 있도록.
     * **/
    public static interface ImageSelection{
        public void onImageSelect(int postion);
    }

    /**
     * 구현 된 인터페이스 콜백 선언.
     * **/
    public ImageSelection callback;

    /**
     * 프래그먼트가 시작할 때 가장 먼저 실행되는 메소드
     * 즉 액티비티와 프래그먼트가 연결 될 때 실행.
     * 파라미터로 받은 context는 액티비티. 액티비티 객체가 전달 되는 것.
     * **/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // ImageSelection type이면 callback에 ImageSelection으로 캐스팅 한다.
        if(context instanceof ImageSelection){

            // 이런식으로 해당 액티비티에 적용 시킬 수 있다
            callback = (ImageSelection) context;

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.list_fragment, container, false);


        ListView listView = viewGroup.findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, title);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(callback != null){
                    // 어느 액티비티와 상관 없이 전부 지정한 타입으로 지정 할 수 있다.
                    callback.onImageSelect(position);
                }

            }
        });

        return viewGroup;
    }
}
