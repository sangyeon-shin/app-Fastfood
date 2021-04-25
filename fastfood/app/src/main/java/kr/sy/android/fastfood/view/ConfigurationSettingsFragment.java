package kr.sy.android.fastfood.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.viewmodel.ConfigurationSettingsViewModel;

public class ConfigurationSettingsFragment extends Fragment {

    private ConfigurationSettingsViewModel dashboardViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(ConfigurationSettingsViewModel.class);
        //onResume();
        View root = inflater.inflate(R.layout.fragment_dashboard4, container, false);

        MobileAds.initialize(this.requireContext(), new OnInitializationCompleteListener() {

            @Override

            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }

        });

        AdView mAdView = root.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(adRequest);


        return root;
    }
}