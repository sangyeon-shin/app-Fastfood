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

import kr.sy.android.fastfood.R;

public class TabFragment_0 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_0, container, false);

        //ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        ListView listView = (ListView)view.findViewById(R.id.listView0);
        listView.setAdapter(adapter);

        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");
        adapter.addItem("로고1","맥도날드");






        /*
        ArrayList<String> words = new ArrayList<String>();
        words.add("맥도날드");
        words.add("롯데리아");
        words.add("버거킹");
        words.add("맘스터치");
        words.add("쉑섹버거");
        words.add("하버거");
        words.add("신버거");
        words.add("조버거");
        words.add("이버거");
        words.add("민버거");


        ListView listView = (ListView)view.findViewById(R.id.listView0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,words);
        listView.setAdapter(adapter);
         */

        return view;
    }
}
