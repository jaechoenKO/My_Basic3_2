package com.exam.app2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setSubtitle("서브 타이틀");
        textView = findViewById(R.id.tv01);


    }

    public void btnClicked(View view) {

        actionBar.setLogo(android.R.drawable.ic_dialog_info);
        /**
         * 미리 정해져 있는 상수를 이용해서 로고, 홈 아이콘 표시.
         * DISPLAY_SHOW_HOME : 홈 아이콘을 표시 하도록.
         **/
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);

    }

    /**
     * 메뉴를 해당 엑티비티에 추가 하기 위한 메소드
     * **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item01:
                textView.setText("메뉴1");
                break;
            case R.id.item02:
                textView.setText("메뉴2");
                break;
            case R.id.item03:
                textView.setText("메뉴3");
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
