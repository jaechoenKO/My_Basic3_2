package com.exam.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv01);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);

        // 메뉴 아이템 찾기, 커스텀 레이아웃 불러오기. 뷰 객체로 참조
        View findView = menu.findItem(R.id.item02).getActionView();

        if(findView != null){
            editText = findView.findViewById(R.id.et01);

            if(editText != null){
                editText.setOnEditorActionListener(findListener);
            }

        }else{
            Toast.makeText(getApplicationContext(), "액션뷰 없음", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item01:
                textView.setText("메뉴1");
                return true;
            case R.id.item02:
//                여기에선 적용이 안됨. 아마 커스텀이라 그런듯.
//                textView.setText("메뉴2");
                return true;
            case R.id.item03:
                textView.setText("메뉴3");
                return true;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 액션 리스너
     * **/
    private TextView.OnEditorActionListener findListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            // 키 값, ACTION_UP : 엔터를 누른 효과
            if(event == null || event.getAction() == KeyEvent.ACTION_UP){

                find();
                /**
                 * 키패드 처리 객체 : InputMethodManager 객체.
                 * **/
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                // 키패드 닫기
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                textView.setText("메뉴2");
            }

            return true;
        }
    };

    // 입력한 내용을 화면에 뿌려주는 메소드
    private void find(){
        // editText의 내용을 가져옴.
        String findString = editText.getEditableText().toString();
        Toast.makeText(this, "검색어" + findString, Toast.LENGTH_SHORT).show();
    }

}
