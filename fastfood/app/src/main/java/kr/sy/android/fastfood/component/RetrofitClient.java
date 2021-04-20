package kr.sy.android.fastfood.component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private RetrofitClient(){}

    private static class RetrofitClientHolder{
        private static Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        public static final Retrofit INSTANCE = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).baseUrl("http://13.58.187.197:8080").build();
    }

    public static Retrofit getInstance(){
        return RetrofitClientHolder.INSTANCE;
    }

    private static class DBServiceHolder{
        public static final DBService dbService = getInstance().create(DBService.class);
    }

    public static DBService getService(){return DBServiceHolder.dbService;}
}
