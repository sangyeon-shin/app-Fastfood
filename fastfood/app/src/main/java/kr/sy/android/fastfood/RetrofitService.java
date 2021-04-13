package kr.sy.android.fastfood;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private RetrofitService(){}

    private static class RetrofitServiceHolder{
        public static final Retrofit INSTANCE = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://13.58.187.197:8080").build();
    }

    public static Retrofit getInstance(){
        return RetrofitServiceHolder.INSTANCE;
    }

    private static class DBServiceHolder{
        public static final DBService dbService = getInstance().create(DBService.class);
    }

    public static DBService getService(){return DBServiceHolder.dbService;}
}
