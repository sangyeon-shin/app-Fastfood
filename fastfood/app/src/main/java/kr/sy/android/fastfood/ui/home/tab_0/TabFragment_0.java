package kr.sy.android.fastfood.ui.home.tab_0;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.sy.android.fastfood.Database;
import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.DBService;
import kr.sy.android.fastfood.ui.home.CustomerAdapter;
import kr.sy.android.fastfood.ui.home.ListViewAdapter;
import kr.sy.android.fastfood.ui.home.TabListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabFragment_0 extends Fragment {

    private FragmentActivity myContext;
    List<TabListViewModel> loadedlist = null;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_0, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.listView0);
        LinearLayoutManager layoutManager = new LinearLayoutManager(myContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        Database db = new Database();
        db.getList(1);
        System.out.println(db.list);
        if(db.list != null) {
            CustomerAdapter adapter = new CustomerAdapter(myContext);
            adapter.addItem(db.list);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

}
