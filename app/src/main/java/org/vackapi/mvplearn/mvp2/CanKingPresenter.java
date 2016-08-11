package org.vackapi.mvplearn.mvp2;

import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.vackapi.mvplearn.mvp2.moudle.CanKingFactory;
import org.vackapi.mvplearn.mvp2.moudle.CanKingItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/8/2.
 */
public class CanKingPresenter implements CanKingTaskPresenter{
    private CanKingViewOperater canKingViewOperater;
    private CanKingFactory canKingFactory;
    private OkHttpClient okHttpClient;
    public static final String GET_EARTH_LIST="http://www.princeblog.com/api/index/getearth_list";
    private int currentPage=1,totalPage=2;

    public CanKingPresenter(CanKingViewOperater canKingViewOperater, CanKingFactory canKingFactory) {
        this.canKingViewOperater = canKingViewOperater;
        this.canKingFactory = canKingFactory;
        okHttpClient=new OkHttpClient();
        canKingViewOperater.getAdapter().setOnItemClickListener(new CanKingItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                canKingViewOperater.onItemClick(position);
            }
        });
    }

    @Override
    public void addItem(int page) {
        if(page<totalPage){
            load(page);
        }else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                        canKingViewOperater.showNoMore();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).run();
        }
    }

    @Override
    public ArrayList<CanKingItem> getItemList() {
        return canKingFactory.getData();
    }
    private void load(int page){
        Request reques=new Request.Builder().url(GET_EARTH_LIST+"?page="+page).get().build();
        Call call=okHttpClient.newCall(reques);
        canKingViewOperater.onLoading();
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                canKingViewOperater.showDataError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    canKingViewOperater.onItemAdding();
                    JSONObject jsonObject=new JSONObject(response.body().string());
                    currentPage=jsonObject.getInt("page");
                    totalPage=jsonObject.getInt("count");
                    ArrayList<CanKingItem> data= new Gson().fromJson(jsonObject.getJSONArray("list").toString(),new TypeToken<ArrayList<CanKingItem>>(){}.getType());
                    canKingFactory.addItem(data);
                    canKingViewOperater.onItemAdded();
                    canKingViewOperater.onLoadComplete(currentPage);
                } catch (JSONException e) {
                    canKingViewOperater.showDataError(e);
                }
            }
        });
    }
}
