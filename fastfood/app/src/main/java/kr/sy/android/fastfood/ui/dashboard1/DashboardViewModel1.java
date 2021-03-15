package kr.sy.android.fastfood.ui.dashboard1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel1 extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModel1() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public void getText() {
        //return mText;
    }
}