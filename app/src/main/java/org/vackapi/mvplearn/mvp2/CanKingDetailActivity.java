package org.vackapi.mvplearn.mvp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.vackapi.mvplearn.R;
import org.vackapi.mvplearn.mvp2.moudle.CanKingList;
import org.vackapi.mvplearn.retrofitLearn.ApiService;
import org.vackapi.mvplearn.retrofitLearn.RetrofitLearnActivity;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CanKingDetailActivity extends AppCompatActivity {
    private Toolbar toolbar_canKing_detail;
    private TextView textView_canKingDetail_title;
    private TextView textView_canKingDetail_date;
    private String title,date,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canking_detail);
        title=getIntent().getStringExtra("post_title");
        date=getIntent().getStringExtra("post_date");
        id=getIntent().getStringExtra("id");
        initView();
    }
    private void initView() {
        toolbar_canKing_detail = (Toolbar) findViewById(R.id.toolbar_canKing_detail);
        setSupportActionBar(toolbar_canKing_detail);
        toolbar_canKing_detail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView_canKingDetail_title = (TextView) findViewById(R.id.textView_canKingDetail_title);
        textView_canKingDetail_title.setText(title);
        textView_canKingDetail_date = (TextView) findViewById(R.id.textView_canKingDetail_date);
        textView_canKingDetail_date.setText(date);
    }
    private void loadData(){
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(RetrofitLearnActivity.GET_EARTH_BASE).build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<CanKingList> getCanKingItem=apiService.getCanKingList("1");
    }
}
