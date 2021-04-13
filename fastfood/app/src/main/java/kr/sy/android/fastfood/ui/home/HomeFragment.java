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

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.DBService;
import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.RetrofitService;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentActivity myContext;
    static List<Company> loadedlist = null; //라이브 데이터에 넣어야함

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

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        homeViewModel.loadCompany(1);
        homeViewModel.getCompanyLiveData().observe(this.getViewLifecycleOwner(),companyObserver);

        // TabLayout 뷰를 가져온다.
        TabLayout tabs = (TabLayout) root.findViewById(R.id.tabLayout);
        // 탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                
                if(position == 0){
                    //updateList(1,recyclerView);
                }else if (position == 1){
                    //updateList(2,recyclerView);
                }else if (position == 2){
                    //updateList(3,recyclerView);
                }else if (position == 3){
                    //updateList(4,recyclerView);
                }else if (position == 4){
                    //updateList(5,recyclerView);
                }else if (position == 5){
                    //updateList(6,recyclerView);
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