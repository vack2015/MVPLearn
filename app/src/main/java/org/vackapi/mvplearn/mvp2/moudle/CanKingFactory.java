package org.vackapi.mvplearn.mvp2.moudle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.vackapi.mvplearn.mvp2.CanKingViewOperater;
import org.vackapi.mvplearn.mvp2.presenter.CanKingDetailPresenter;
import org.vackapi.mvplearn.mvp2.presenter.CanKingPresenter;

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
public class CanKingFactory {
    private ArrayList<CanKingItem> data=new ArrayList<>();
    private int currentPage=1,totalPage=2;
    private OkHttpClient okHttpClient;
    private CanKingPresenter canKingPresenter;

    public CanKingFactory() {
        okHttpClient=new OkHttpClient();
    }

    public void setCanKingPresenter(CanKingPresenter canKingPresenter){
        this.canKingPresenter=canKingPresenter;
    }


    public void addItems(int page) {
        if(currentPage>totalPage){
            canKingPresenter.showNoMore();
        }

        Request reques=new Request.Builder().url(CanKingPresenter.GET_EARTH_LIST+"?page="+page).get().build();
        Call call=okHttpClient.newCall(reques);
        canKingPresenter.onLoading();
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                canKingPresenter.showDataError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    canKingPresenter.onItemAdding();
                    JSONObject jsonObject=new JSONObject(response.body().string());
                    currentPage=jsonObject.getInt("page");
                    totalPage=jsonObject.getInt("count");
                    ArrayList<CanKingItem> new_data= new Gson().fromJson(jsonObject.getJSONArray("list").toString(),new TypeToken<ArrayList<CanKingItem>>(){}.getType());
                    data.addAll(new_data);
                    canKingPresenter.onItemAdded();
                    canKingPresenter.onLoadComplete(currentPage,totalPage);
                } catch (JSONException e) {
                    canKingPresenter.showDataError(e);
                }
            }
        });
        //data.addAll(items);
    }

    public ArrayList<CanKingItem> getData(){
        return data;
    }
}
