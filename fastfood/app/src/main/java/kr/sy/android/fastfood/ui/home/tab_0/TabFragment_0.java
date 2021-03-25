package kr.sy.android.fastfood.ui.home.tab_0;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.ui.home.HomeFragment;
import kr.sy.android.fastfood.ui.home.HomeViewModel;

public class TabFragment_0 extends Fragment {

    public ArrayList<TabListViewModel_0> list = new ArrayList<TabListViewModel_0>();
    private final String TAG = "TabFragment_0";
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_0, container, false);

        //TabFragment_0 fragment0 = new TabFragment_0();
        //myContext.getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment0).commit();
        ListView listView = (ListView)view.findViewById(R.id.listView0);
        ConnectServer();
        ListViewAdapter adapter = new ListViewAdapter(list);
        listView.setAdapter(adapter);


        return view;
    }

    private void ConnectServer(){
        final String SIGNIN_URL = "http://13.58.187.197:8080/load_tablist.jsp";
        final String urlSuffix = "?category_index=1";
        Log.d("urlSuffix", urlSuffix);
        class SignupUser extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Log.d(TAG,s);
                if (s != null) {
                    try{

                        JSONArray jArr = new JSONArray(s);;
                        JSONObject json = new JSONObject();
                        for (int i = 0; i < jArr.length(); i++) {
                            json = jArr.getJSONObject(i);
                            String companyindex = json.getString("companyindex");
                            String companyname = json.getString("companyname");
                            String description = json.getString("description");
                            String image = json.getString("image");
                            String categoryindex = json.getString("categoryindex");
                            TabListViewModel_0 tab = new TabListViewModel_0();
                            tab.setCompany_index(Integer.parseInt(companyindex));
                            tab.setCompany_name(companyname);
                            tab.setDescription(description);
                            tab.setImage(image);
                            tab.setCategory_index(Integer.parseInt(categoryindex));
                            list.add(tab);
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } else {
                    //Toast.makeText(MainActivity.this, "서버와의 통신에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                BufferedReader bufferedReader = null;

                try {

                    HttpClient client = new DefaultHttpClient();  // 보낼 객체 만들기
                    HttpPost post = new HttpPost(SIGNIN_URL + urlSuffix);  // 주소 뒤에 데이터를 넣기

                    HttpResponse response = client.execute(post); // 데이터 보내기

                    BufferedReader bufreader = new BufferedReader(
                            new InputStreamReader(
                                    response.getEntity().getContent(), "utf-8"));

                    String line = null;
                    String page = "";

                    while ((line = bufreader.readLine()) != null) {
                        page += line;
                    }
                    Log.d(TAG, page);
                    return page;
                } catch (Exception e) {
                    return null;
                }
            }
        }

        SignupUser su = new SignupUser();
        su.execute(urlSuffix);
    }
}
