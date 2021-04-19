package kr.sy.android.fastfood.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodayDealViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TodayDealViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public void getText() {
        //return mText;
    }
}