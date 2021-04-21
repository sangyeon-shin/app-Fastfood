package kr.sy.android.fastfood.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.component.CompanyServiceImpl;
import kr.sy.android.fastfood.injection.TodayDealViewModelFactory;
import kr.sy.android.fastfood.model.Company;
import kr.sy.android.fastfood.view.action.CustomDialogClickListener;
import kr.sy.android.fastfood.view.action.OnItemClickListener;
import kr.sy.android.fastfood.view.adapter.CustomerAdapter;
import kr.sy.android.fastfood.view.dialog.CompanyDetailDialog;
import kr.sy.android.fastfood.viewmodel.TodayDealViewModel;

public class TodayDealFragment extends Fragment {

    private TodayDealViewModel todayDealViewModel;
    private CompanyServiceImpl cService = new CompanyServiceImpl();
    private TextView date;
    private RecyclerView recyclerView;

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayDealViewModel = new ViewModelProvider(this, new TodayDealViewModelFactory(cService)).get(TodayDealViewModel.class);
        todayDealViewModel.getCompanyLiveData().observe(this.getViewLifecycleOwner(),companyObserver());
        onStop();
        View root = inflater.inflate(R.layout.fragment_dashboard1, container, false);
        setDate(root,todayDealViewModel.getTodaysDate());
        recyclerView = (RecyclerView)root.findViewById(R.id.todayRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }

    private void setDate(View root,String todaysDate){
        date = (TextView)root.findViewById(R.id.date);
        date.setText(todaysDate);
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
        adapter.setOnItemClicklistener(new OnItemClickListener() {
            @Override
            public void onItemClick(CustomerAdapter.ViewHolder holder, View view, int position) {
                Company company = adapter.getItem(position);
                //Toast.makeText(getActivity().getApplicationContext(),"아이템 선택 " + company.getCompany_name(), Toast.LENGTH_LONG).show();
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