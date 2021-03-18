package kr.sy.android.fastfood.ui.home.tab_0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import kr.sy.android.fastfood.DataBase;
import kr.sy.android.fastfood.R;

public class TabFragment_0 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_0, container, false);

        DataBase db = new DataBase();
        String list = db.loadList("hamburger");
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        ListView listView = (ListView)view.findViewById(R.id.listView0);
        listView.setAdapter(adapter);

        adapter.addItem(list);
        return view;
    }
}
