package kr.sy.android.fastfood.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.ui.CompanyDetailDialog;
import kr.sy.android.fastfood.ui.CompanyService;
import kr.sy.android.fastfood.ui.CustomDialogClickListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CompanyService cService = new CompanyService();
    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(cService)).get(HomeViewModel.class);
        homeViewModel.getCompanyLiveData().observe(this.getViewLifecycleOwner(),companyObserver());
        //뷰 생성
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // TabLayout 뷰를 가져온다.
        tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        addOnTabSelectedListener(tabLayout);
        // 탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.

        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);



        return root;
    }

    private void addOnTabSelectedListener(TabLayout tabLayout){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
    }

    private Observer<List<Company>> companyObserver(){
        final Observer<List<Company>> companyObserver = new Observer<List<Company>>() {
            @Override
            public void onChanged(List<Company> companyList) {
                recyclerView.setAdapter(updateRecyclerView(companyList));
            }
        };
        return companyObserver;
    }

    private CustomerAdapter updateRecyclerView(List<Company> companyList){
        //여기서 리사이클러뷰 갱신
        CustomerAdapter adapter = new CustomerAdapter(this.getActivity());

        for(Company company : companyList) {
            adapter.addItem(company);
        }

        createClickListener(adapter);

        return adapter;
    }

    private CustomerAdapter createClickListener(CustomerAdapter adapter){
        adapter.setOnItemClicklistener(new onItemClickListener() {
            @Override
            public void onItemClick(CustomerAdapter.ViewHolder holder, View view, int position) {
                Company company = adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(),"아이템 선택 " + company.getCompany_name(), Toast.LENGTH_LONG).show();
                dialogButtonListener(company);
            }
        });

        return adapter;
    }

    private CompanyDetailDialog dialogButtonListener(Company company){
        CompanyDetailDialog dialog = new CompanyDetailDialog(getContext(), company, new CustomDialogClickListener() {
            @Override
            public void onPositiveClick() {
                Log.d("Test","OK click");
            }

            @Override
            public void onNegativeClick() {
                Log.d("Test", "Cancel click");
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        dialog.show();

        return dialog;
    }

}