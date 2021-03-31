package kr.sy.android.fastfood.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.ui.home.tab_0.TabFragment_0;
import kr.sy.android.fastfood.ui.home.tab_1.TabFragment_1;
import kr.sy.android.fastfood.ui.home.tab_2.TabFragment_2;
import kr.sy.android.fastfood.ui.home.tab_3.TabFragment_3;
import kr.sy.android.fastfood.ui.home.tab_4.TabFragment_4;
import kr.sy.android.fastfood.ui.home.tab_5.TabFragment_5;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        //뷰 생성
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //메인화면에 설정할 프래그먼트
        Fragment fragment0 = new TabFragment_0();
        myContext.getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment0).commit();

        // TabLayout 뷰를 가져온다.
        TabLayout tabs = (TabLayout) root.findViewById(R.id.tabLayout);
        // 탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = fragment0;
                }else if (position == 1){
                    selected = new TabFragment_1();
                }else if (position == 2){
                    selected = new TabFragment_2();
                }else if (position == 3){
                    selected = new TabFragment_3();
                }else if (position == 4){
                    selected = new TabFragment_4();
                }else if (position == 5){
                    selected = new TabFragment_5();
                }

                myContext.getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

}