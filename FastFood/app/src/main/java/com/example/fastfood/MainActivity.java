package com.example.fastfood;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Fragment fragment0, fragment1, fragment2, fragment3, fragment4, fragment5;
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); // activity_main안에 있는 속성들을 id값으로 식별해서 view를 찾아줌
        setSupportActionBar(toolbar); // 찾아온 view를 ActionBar로 설정
        ActionBar actionBar = getSupportActionBar(); // 액션바를 가져온다
        actionBar.setDisplayShowCustomEnabled(true); // 액션바 커스텀 가능하게 해준다.
        actionBar.setDisplayShowTitleEnabled(false); // 기본 제목을 없애줍니다.

        //각각의 레이아웃 조각 생성
        fragment0 = new Fragment0();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment0).commit(); //초기 화면 설정

        TabLayout tabs = (TabLayout) findViewById(R.id.tabLayout); // TabLayout 뷰를 가져온다.

        // 탭 레이아웃을 추가합니다.탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = fragment0;

                }else if (position == 1){
                    selected = fragment1;

                }else if (position == 2){
                    selected = fragment2;

                }else if (position == 3){
                    selected = fragment3;

                }else if (position == 4){
                    selected = fragment4;

                }else if (position == 5){
                    selected = fragment5;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                //select logout item
                break;
            case R.id.account:
                //select account item
                break;
            case R.id.exit:
                //select back button
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}