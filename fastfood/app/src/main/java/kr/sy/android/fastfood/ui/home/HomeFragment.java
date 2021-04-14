package kr.sy.android.fastfood.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import kr.sy.android.fastfood.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentActivity myContext;
    private CompanyService cService = new CompanyService();

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(cService)).get(HomeViewModel.class);
        //뷰 생성
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(myContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // ViewModel 에서 변경된 데이터가 있는지 observing
        final Observer<Company> companyObserver = new Observer<Company>() {
            @Override
            public void onChanged(Company company) {
                recyclerView.setAdapter(updateRecyclerView(company));
            }
        };

        if(homeViewModel.getCompanyLiveData() != null){
            homeViewModel.getCompanyLiveData().observe(this.getViewLifecycleOwner(),companyObserver);
        }

        // TabLayout 뷰를 가져온다.
        TabLayout tabs = (TabLayout) root.findViewById(R.id.tabLayout);
        // 탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                
                if(position == 0){
                    homeViewModel.loadCompany(1);
                }else if (position == 1){
                    homeViewModel.loadCompany(2);
                }else if (position == 2){
                    homeViewModel.loadCompany(3);
                }else if (position == 3){
                    homeViewModel.loadCompany(4);
                }else if (position == 4){
                    homeViewModel.loadCompany(5);
                }else if (position == 5){
                    homeViewModel.loadCompany(6);
                }

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

    private CustomerAdapter updateRecyclerView(Company company){
        //여기서 리사이클러뷰 갱신
        CustomerAdapter adapter = new CustomerAdapter(myContext);
        adapter.addItem(company);
        return adapter;
    }

}