package kr.sy.android.fastfood.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import javax.inject.Inject;

import kr.sy.android.fastfood.ui.CompanyService;


public class HomeViewModelFactory implements ViewModelProvider.Factory {
    private final CompanyService mService;

    @Inject
    public HomeViewModelFactory(CompanyService service) {
        mService = service;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        return (T) new HomeViewModel(mService);
    }
}

