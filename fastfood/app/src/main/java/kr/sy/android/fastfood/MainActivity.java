package kr.sy.android.fastfood;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); // activity_main안에 있는 속성들을 id값으로 식별해서 view를 찾아줌
        setSupportActionBar(toolbar); // 찾아온 view를 ActionBar로 설정
        ActionBar actionBar = getSupportActionBar(); // 액션바를 가져온다
        actionBar.setDisplayShowCustomEnabled(true); // 액션바 커스텀 가능하게 해준다.
        actionBar.setDisplayShowTitleEnabled(false); // 기본 제목을 없애줍니다.

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard1, R.id.navigation_dashboard2, R.id.navigation_dashboard3, R.id.navigation_dashboard4)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}