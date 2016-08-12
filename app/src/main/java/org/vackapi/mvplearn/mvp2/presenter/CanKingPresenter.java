package org.vackapi.mvplearn.mvp2.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.vackapi.mvplearn.mvp2.CanKingItemAdapter;
import org.vackapi.mvplearn.mvp2.CanKingViewOperater;
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


    public CanKingPresenter(CanKingViewOperater canKingViewOperater, CanKingFactory canKingFactory) {
        this.canKingViewOperater = canKingViewOperater;
        this.canKingFactory = canKingFactory;
        canKingFactory.setCanKingPresenter(this);
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
        canKingFactory.addItems(page);
    }

    @Override
    public ArrayList<CanKingItem> getItemList() {
        return canKingFactory.getData();
    }

    @Override
    public void showNoMore() {
        canKingViewOperater.showNoMore();
    }

    @Override
    public void onLoading() {
        canKingViewOperater.onLoading();
    }

    @Override
    public void showDataError(Exception e) {
        canKingViewOperater.showDataError(e);
    }

    @Override
    public void onItemAdding() {
        canKingViewOperater.onItemAdding();
    }

    @Override
    public void onItemAdded() {
        canKingViewOperater.onItemAdded();
    }

    @Override
    public void onLoadComplete(int currentPage, int totalPage) {
        canKingViewOperater.onLoadComplete(currentPage,totalPage);
    }
}
