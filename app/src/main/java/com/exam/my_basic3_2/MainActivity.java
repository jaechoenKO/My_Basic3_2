package com.exam.my_basic3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv01);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // 인플레이션 처리를 해야 아이템을 사용할 수 있다.
        getMenuInflater().inflate(R.menu.menu_item, menu);

        return true;
    }

    /**
     * 아이템을 눌렀을 때 반응.
     * **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item01:
                Toast.makeText(this, "menu1", Toast.LENGTH_LONG).show();
                break;
            case R.id.item02:
                Toast.makeText(this, "menu2", Toast.LENGTH_LONG).show();
                break;
            case R.id.item03:
                Toast.makeText(this, "menu3", Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }
        textView.setText(item.getTitle().toString());
        return false;
    }
}
