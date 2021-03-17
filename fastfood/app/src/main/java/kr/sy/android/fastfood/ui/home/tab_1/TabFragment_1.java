package kr.sy.android.fastfood.ui.home.tab_1;

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

public class TabFragment_1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_1, container, false);

        ArrayList<String> words = new ArrayList<String>();
        words.add("BBQ");
        words.add("BHC");
        words.add("네네치킨");
        words.add("멕시카나");
        words.add("교촌치킨");
        words.add("하치킨");
        words.add("신치킨");
        words.add("조치킨");
        words.add("이치킨");
        words.add("민치킨");



        ListView listView = (ListView)view.findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,words);
        listView.setAdapter(adapter);

        return view;
    }
}
