package kr.sy.android.fastfood;

import java.util.List;


import io.reactivex.rxjava3.core.Single;
import kr.sy.android.fastfood.ui.home.TabListViewModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DBService {

    @GET("/load_tablist.jsp")
    Call<List<TabListViewModel>> getCominfo(@Query("category_index") int num);

    @GET("/load_tablist.jsp")
    Call<Single<List<TabListViewModel>>> getCompanyinfo(@Query("category_index") int num);
}
