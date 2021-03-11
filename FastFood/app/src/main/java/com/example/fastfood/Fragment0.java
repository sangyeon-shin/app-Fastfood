package com.example.fastfood;

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

public class Fragment0 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment0, container, false);

        ArrayList<String> words = new ArrayList<String>();
        words.add("맥도날드");
        words.add("롯데리아");
        words.add("버거킹");
        words.add("서브웨이");
        words.add("쉑섹버거");

        ListView listView = (ListView)view.findViewById(R.id.listView0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,words);
        listView.setAdapter(adapter);

        return view;
    }
}
