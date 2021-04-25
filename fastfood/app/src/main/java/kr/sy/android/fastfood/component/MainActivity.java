package kr.sy.android.fastfood.component;

import android.os.Bundle;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import kr.sy.android.fastfood.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar); // 뷰를 찾아온다.
        setSupportActionBar(toolbar); // 찾아온 뷰를 ActionBar로 설정
        ActionBar actionBar = getSupportActionBar(); // (설정하려고)액션바를 가져온다.
        actionBar.setDisplayShowCustomEnabled(true); // 액션바 커스텀 가능하게 해준다.
        actionBar.setDisplayShowTitleEnabled(false); // 기본 제목을 없앤다.

        BottomNavigationView navView = findViewById(R.id.nav_view); //뷰를 찾아온다.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard1, R.id.navigation_dashboard2, R.id.navigation_dashboard3, R.id.navigation_dashboard4)
                .build(); //앱바 환경설정해서 만든다.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // 메인 화면에서 컨트롤러와 연관된 뷰를 찾아온다.
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); //액티비티에 컨트롤러와 환경설정을 주입.
        NavigationUI.setupWithNavController(navView, navController); //네비뷰에 컨트롤러와 환경설정을 주입.

        MobileAds.initialize(this, new OnInitializationCompleteListener() { @Override public void onInitializationComplete(InitializationStatus initializationStatus) { } });

    }

}