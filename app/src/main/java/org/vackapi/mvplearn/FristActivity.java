package org.vackapi.mvplearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.vackapi.mvplearn.mvp3.MVP3Activity;
import org.vackapi.mvplearn.retrofitLearn.RetrofitLearnActivity;
import org.vackapi.mvplearn.rxjavalearn.RxJavaLearnActivity;
import org.vackapi.mvplearn.mvp.MVPLearnActivity;
import org.vackapi.mvplearn.mvp2.MVP2Activity;
import org.vackapi.mvplearn.R;

public class FristActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
    }

    public void retrofitLearn(View view){
        startActivity(new Intent(getApplicationContext(), RetrofitLearnActivity.class));
    }

    public void rxJavaLearn(View view){
        Intent intent=new Intent(getApplicationContext(), RxJavaLearnActivity.class);
        startActivity(intent);
    }
    public void mvpLearn(View view){
        Intent intent=new Intent(getApplicationContext(), MVPLearnActivity.class);
        startActivity(intent);
    }
    public void canKingMVP(View view){
        Intent intent=new Intent(getApplicationContext(),MVP2Activity.class);
        startActivity(intent);
    }
    public void mvpLearn3(View view){
        Intent intent=new Intent(getApplicationContext(), MVP3Activity.class);
        startActivity(intent);
    }
}
