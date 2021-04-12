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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.DBService;
import kr.sy.android.fastfood.R;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentActivity myContext;
    static List<TabListViewModel> loadedlist = null; //라이브 데이터에 넣어야함

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

        updateList(1,recyclerView);

        // TabLayout 뷰를 가져온다.
        TabLayout tabs = (TabLayout) root.findViewById(R.id.tabLayout);
        // 탭 선택이 변경될 때 호출되는 탭 선택 수신기입니다.
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();
                
                if(position == 0){
                    updateList(1,recyclerView);
                }else if (position == 1){
                    updateList(2,recyclerView);
                }else if (position == 2){
                    updateList(3,recyclerView);
                }else if (position == 3){
                    updateList(4,recyclerView);
                }else if (position == 4){
                    updateList(5,recyclerView);
                }else if (position == 5){
                    updateList(6,recyclerView);
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

    public Single<List<TabListViewModel>> fetchCompanyinfo(int category_index){
        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://13.58.187.197:8080").build();

        DBService service = retrofit.create(DBService.class);

        return service.getCompanyinfo(category_index).subscribeOn(Schedulers.io());
    }

    private void updateList(int category_index,RecyclerView recyclerView){
        fetchCompanyinfo(category_index).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        v -> loadedlist = v.subList(0,v.size()) ,
                        err -> System.err.println("onError() : err :" + err.getMessage()));

    }

    private void updateUI(RecyclerView recyclerView){
        if(loadedlist != null) {
            CustomerAdapter adapter = new CustomerAdapter(myContext);
            adapter.addItem(loadedlist);
            recyclerView.setAdapter(adapter);
        }
    }

}