package kr.sy.android.fastfood.ui;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.DBService;
import kr.sy.android.fastfood.RetrofitService;
import kr.sy.android.fastfood.ui.home.Company;

public class CompanyService {

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
