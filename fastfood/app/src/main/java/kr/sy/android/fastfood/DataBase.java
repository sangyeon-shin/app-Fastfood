package kr.sy.android.fastfood;


import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kr.sy.android.fastfood.ui.home.TabListViewModel;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Database {

    public static List<TabListViewModel> list = null;
    /*
    DBService service = createRetrofit("http://13.58.187.197:8080").create(DBService.class);

    Single<Response<List<TabListViewModel>>> getList = service.getCompanyinfo(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    private Retrofit createRetrofit(String baseUrl){
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectionPool(new ConnectionPool(5, 20, TimeUnit.SECONDS))
                        .build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
    */

    public void getList(int category_num){
        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://13.58.187.197:8080").build();

        DBService service = retrofit.create(DBService.class);

        service.getCompanyinfo(category_num).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(v -> list = v.subList(0,v.size()),
                err -> System.err.println("onError() : err :" + err.getMessage()));

    }

    /*
    public void getList(int category_num){
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

    }
    */

}
