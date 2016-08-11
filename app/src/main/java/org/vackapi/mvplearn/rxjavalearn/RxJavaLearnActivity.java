package org.vackapi.mvplearn.rxjavalearn;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.vackapi.mvplearn.R;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class RxJavaLearnActivity extends AppCompatActivity {
    private ProgressDialog pd;
    private Toolbar toolbar;
    private TextView textView_rxJava_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        toolbar= (Toolbar) findViewById(R.id.toolbar_rxJava);
        textView_rxJava_content= (TextView) findViewById(R.id.textView_rxJava_content);
        setSupportActionBar(toolbar);

    }

    public void onClick_Rxjava_l(View view){
        operate0();
    }

    public void onClick_Rxjava_a(View view){
        operate1();
    }
    public void onClick_Rxjava_s(View view){
        operate2();
    }

    public void onClick_Rxjava_l2(View view){
        Observable<String> stringObservable=Observable.just("operate4");
        stringObservable.observeOn(AndroidSchedulers.mainThread())
                .map(String::toUpperCase)
                .subscribe(textView_rxJava_content::setText);
    }

    private void operate0(){
        Observable<String> stringObservable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("aaaaaaaaa");
                subscriber.onCompleted();
            }
        });
        stringObservable.subscribe(textView_rxJava_content::setText);
    }

    private void operate1(){
        Observable<String> stringObservable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("sssssssssss");
                subscriber.onCompleted();
            }
        });
        stringObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                textView_rxJava_content.setText(s);
            }
        });
    }


    private void operate2(){
        //注册订阅者
        Subscriber<String> textSubscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                textView_rxJava_content.setText(s);
            }
        };

        //注册观察者
        Observable<String> stringObservable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //甚至可以在这里用httpurlconnetion加载数据
                subscriber.onNext("Hello World");
                subscriber.onCompleted();
            }
        }).observeOn(AndroidSchedulers.mainThread())  // 指定 Subscriber 的回调发生在主线程
          .subscribeOn(Schedulers.io());  //指定 subscribe() 发生在 IO 线程
        //订阅
        stringObservable.subscribe(textSubscriber);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
