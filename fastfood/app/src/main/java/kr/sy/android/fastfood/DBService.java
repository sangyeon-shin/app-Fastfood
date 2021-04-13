package kr.sy.android.fastfood;


import java.util.List;


import io.reactivex.Single;
import kr.sy.android.fastfood.ui.home.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DBService {

    @GET("/load_tablist.jsp")
    Call<List<Company>> getCominfo(@Query("category_index") int num);

    @GET("/load_tablist.jsp")
    Single<List<Company>> getCompanyinfo(@Query("category_index") int num);
}


