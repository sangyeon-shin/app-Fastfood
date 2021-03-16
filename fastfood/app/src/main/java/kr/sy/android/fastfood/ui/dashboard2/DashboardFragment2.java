package kr.sy.android.fastfood.ui.dashboard2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import kr.sy.android.fastfood.R;

public class DashboardFragment2 extends Fragment {

    private kr.sy.android.fastfood.ui.dashboard2.DashboardViewModel2 dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(kr.sy.android.fastfood.ui.dashboard2.DashboardViewModel2.class);
        onResume();
        View root = inflater.inflate(R.layout.fragment_dashboard2, container, false);
        /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */
        return root;
    }
}