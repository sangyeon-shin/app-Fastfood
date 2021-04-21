package kr.sy.android.fastfood.injection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import kr.sy.android.fastfood.component.CompanyServiceImpl;
import kr.sy.android.fastfood.viewmodel.TodayDealViewModel;

public class TodayDealViewModelFactory implements ViewModelProvider.Factory {
    private final CompanyServiceImpl mService;

    @Inject
    public TodayDealViewModelFactory(CompanyServiceImpl service) {
        mService = service;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        return (T) new TodayDealViewModel(mService);
    }
}
