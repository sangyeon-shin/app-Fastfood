package kr.sy.android.fastfood.ui.dashboard2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel2 extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel2() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public void getText() {
        //return mText;
    }
}