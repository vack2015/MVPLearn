package org.vackapi.mvplearn.mvp2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.vackapi.mvplearn.R;
import org.vackapi.mvplearn.customview.MyWebView;
import org.vackapi.mvplearn.mvp2.moudle.CanKingDetail;
import org.vackapi.mvplearn.mvp2.moudle.CanKingList;
import org.vackapi.mvplearn.mvp2.presenter.CanKingDetailPresenter;
import org.vackapi.mvplearn.retrofitLearn.ApiService;
import org.vackapi.mvplearn.retrofitLearn.RetrofitLearnActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CanKingDetailActivity extends AppCompatActivity implements CanKingDetailViewOperater{
    private Toolbar toolbar_canKing_detail;
    private TextView textView_canKingDetail_title;
    private TextView textView_canKingDetail_date;
    private MyWebView mywebView_canKing_Detail;
    private ProgressDialog pd;
    private String title,date,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canking_detail);
        title=getIntent().getStringExtra("post_title");
        date=getIntent().getStringExtra("post_date");
        id=getIntent().getStringExtra("id");
        initView();
        CanKingDetailPresenter canKingDetailPresenter=new CanKingDetailPresenter(this);
        canKingDetailPresenter.loadData(id);
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
        mywebView_canKing_Detail= (MyWebView) findViewById(R.id.mywebView_canKing_Detail);
        mywebView_canKing_Detail.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }
        });
    }

    @Override
    public void onStartLoad() {
        if(pd==null){
            pd=new ProgressDialog(this);
            pd.setMessage("Loading");
        }
        pd.show();
    }

    @Override
    public void onLoadComplete(CanKingDetail canKingDetail) {
        pd.dismiss();
        canKingDetail.setPost_content(canKingDetail.getPost_content());
        textView_canKingDetail_title.setText(canKingDetail.getPost_title());
        textView_canKingDetail_date.setText(canKingDetail.getPost_date());
        mywebView_canKing_Detail.loadDataWithBaseURL(null,canKingDetail.getPost_content(),"text/html","UTF-8",null);
    }

    @Override
    public void onFail(Throwable e) {

    }
}
