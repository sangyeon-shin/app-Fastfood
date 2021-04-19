package kr.sy.android.fastfood.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConfigurationSettingsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ConfigurationSettingsViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    public void getText() {
        //return mText;
    }
}