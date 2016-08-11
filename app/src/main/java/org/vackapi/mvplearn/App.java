package org.vackapi.mvplearn;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;

import java.io.InputStream;

import okhttp3.OkHttpClient;


/**
 * Created by Administrator on 2016/8/2.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Glide.get(this).register(GlideUrl.class, InputStream.class,new OkHttpUrlLoader.Factory(new OkHttpClient()));
    }
}
