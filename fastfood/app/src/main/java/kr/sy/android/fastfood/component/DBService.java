package kr.sy.android.fastfood.component;


import java.util.List;


import io.reactivex.Single;
import kr.sy.android.fastfood.model.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DBService {

    @GET("/load_company.jsp")
    Single<List<Company>> getCompanyList(@Query("category_index") int num);

    @GET("/load_today.jsp")
    Single<List<Company>> getTodayList(@Query("today_date") String todayDate);


}


