package org.vackapi.mvplearn.retrofitLearn;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.vackapi.mvplearn.R;
import org.vackapi.mvplearn.mvp2.moudle.CanKingList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitLearnActivity extends AppCompatActivity {
    public static final String GET_EARTH_BASE="http://www.princeblog.com/api/index/";
    private TextView textView_retrofit;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_learn);
        textView_retrofit= (TextView) findViewById(R.id.textView_retrofit);
    }

    public void load(View view){
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(GET_EARTH_BASE).build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<CanKingList> getCanKingItem=apiService.getCanKingList("1");
        pd=new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        getCanKingItem.enqueue(new Callback<CanKingList>() {

            @Override
            public void onResponse(Call<CanKingList> call, Response<CanKingList> response) {
                //Log.e("VACK", response.body().toString());
                textView_retrofit.setText(response.body().toString());
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<CanKingList> call, Throwable t) {

            }
        });
    }
}
