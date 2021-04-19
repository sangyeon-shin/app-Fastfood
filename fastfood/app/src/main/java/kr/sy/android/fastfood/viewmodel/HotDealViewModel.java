package kr.sy.android.fastfood.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HotDealViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HotDealViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public void getText() {
        //return mText;
    }
}