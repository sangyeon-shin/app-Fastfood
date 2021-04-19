package kr.sy.android.fastfood.component;

import java.util.List;

import io.reactivex.Single;
import kr.sy.android.fastfood.model.Company;

public interface CompanyService {
    public Single<List<Company>> fetchCompanyList(int categoryIndex);
}
