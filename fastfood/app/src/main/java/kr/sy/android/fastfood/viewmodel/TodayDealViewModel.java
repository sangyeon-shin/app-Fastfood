package kr.sy.android.fastfood.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.List;

import io.reactivex.disposables.Disposable;
import kr.sy.android.fastfood.component.CompanyServiceImpl;
import kr.sy.android.fastfood.model.Company;

public class TodayDealViewModel extends ViewModel {

    private CompanyServiceImpl companyServiceImpl;
    private MutableLiveData<List<Company>> companyLiveData = new MutableLiveData();
    private Disposable disposable = null;


    // onClear에서 RxJava에서 사용했던 리소스를 해제해주셔 합니다. 그래야 메모리 누수가 없어요.
    @Override
    public void onCleared() {
        super.onCleared();
        if( disposable != null )
            disposable.dispose();
    }

    public LiveData<List<Company>> getCompanyLiveData() {
        return this.companyLiveData;
    }


    public TodayDealViewModel(CompanyServiceImpl service) {
        this.companyServiceImpl = service;
        loadCompany(getTodaysDate());
    }

    // observeOn이 필요없는 이유는 LiveData.postValue는 백그라운드 쓰레드에서도 값을 전달할 수 있기 때문입니다.
    // liveData.value 를 사용하신다면 메인쓰레드로 전환해야 겠죠.
    public void loadCompany(String todayDate){
        disposable = companyServiceImpl
                .fetchTodayList(todayDate)
                .subscribe(
                        v -> updateCompany(v) ,
                        err -> System.err.println("onError() : err :" + err.getMessage()));

    }


    private void updateCompany(List<Company> companyList) {
        companyLiveData.postValue(companyList);
    }

    public String getTodaysDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMdd");

        String todaysDate = simpleDateFormat.format(System.currentTimeMillis());

        System.out.println(todaysDate);

        return todaysDate;
    }

}