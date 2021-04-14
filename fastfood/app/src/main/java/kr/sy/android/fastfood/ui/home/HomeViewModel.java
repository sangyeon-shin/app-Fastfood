package kr.sy.android.fastfood.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.DBService;
import kr.sy.android.fastfood.RetrofitService;

public class HomeViewModel extends ViewModel {

    private final CompanyService companyService;
    private MutableLiveData<Company> companyLiveData;

    private Disposable disposable = null;


    // onClear에서 RxJava에서 사용했던 리소스를 해제해주셔 합니다. 그래야 메모리 누수가 없어요.
    @Override
    public void onCleared() {
        super.onCleared();
        if( disposable != null )
            disposable.dispose();
    }

    public LiveData<Company> getCompanyLiveData() {
        return this.companyLiveData;
    }


    public HomeViewModel(CompanyService service) {
        this.companyService = service;
    }

    // observeOn이 필요없는 이유는 LiveData.postValue는 백그라운드 쓰레드에서도 값을 전달할 수 있기 때문입니다.
    // liveData.value 를 사용하신다면 메인쓰레드로 전환해야 겠죠.
    public void loadCompany(int categoryIndex){
        disposable = companyService
                .fetchCompany(categoryIndex)
                .subscribe(
                        v -> updateCompany(v) ,
                        err -> System.err.println("onError() : err :" + err.getMessage()));

    }


    private void updateCompany(List<Company> companyList) {
        for(Company company : companyList){
            companyLiveData.postValue(company);
        }
    }

}

//---------------------------------------------------------------------------------------------------------------

class CompanyService {
    private DBService dbService = RetrofitService.getService();

    public CompanyService() {
    }

    public Single<List<Company>> fetchCompany(int categoryIndex) {
        // observeOn이 필요없는 이유는 LiveData.postValue는 백그라운드 쓰레드에서도 값을 전달할 수 있기 때문입니다.
        // liveData.value 를 사용하신다면 메인쓰레드로 전환해야 겠죠.
        return dbService.getCompanyinfo(categoryIndex)
                .subscribeOn(Schedulers.io());
    }


}