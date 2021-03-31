package kr.sy.android.fastfood.ui.home.tab_0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import kr.sy.android.fastfood.Database;
import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.DBService;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_0, container, false);

        ListView listView = (ListView)view.findViewById(R.id.listView0);

        Database db = new Database();

        loadedlist = db.getList(1);

        ListViewAdapter adapter = new ListViewAdapter();
        adapter.addItem(loadedlist);
        listView.setAdapter(adapter);

        return view;
    }

}
