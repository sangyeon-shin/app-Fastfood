package kr.sy.android.fastfood;

import java.util.List;

import kr.sy.android.fastfood.ui.home.TabListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Database {

    static List<TabListViewModel> list = null;

    public List<TabListViewModel> getList(int category_num){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://13.58.187.197:8080").addConverterFactory(GsonConverterFactory.create()).build();

        DBService service = retrofit.create(DBService.class);

        Call<List<TabListViewModel>> call = service.getCominfo(category_num);

        call.enqueue(new Callback<List<TabListViewModel>>() {
            @Override
            public void onResponse(Call<List<TabListViewModel>> call, Response<List<TabListViewModel>> response) {
                response.errorBody();
                if (response.isSuccessful()){
                    list = response.body();
                    System.out.println(list);
                }
            }

            @Override
            public void onFailure(Call<List<TabListViewModel>> call, Throwable t) {
                System.out.println("호출 실패");
                System.out.println(t.getMessage());
            }
        });

        return list;
    }
}
