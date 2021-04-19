package kr.sy.android.fastfood.component;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.model.Company;

public class CompanyServiceImpl implements CompanyService{

    private DBService dbService = RetrofitClient.getService();

    public CompanyServiceImpl() {
    }

    public Single<List<Company>> fetchCompanyList(int categoryIndex) {
        // observeOn이 필요없는 이유는 LiveData.postValue는 백그라운드 쓰레드에서도 값을 전달할 수 있기 때문입니다.
        // liveData.value 를 사용하신다면 메인쓰레드로 전환.
        return dbService.getCompanyList(categoryIndex)
                .subscribeOn(Schedulers.io());
    }
}
