package org.vackapi.mvplearn.mvp2.presenter;

import org.vackapi.mvplearn.mvp2.CanKingDetailViewOperater;
import org.vackapi.mvplearn.mvp2.moudle.CanKingDetail;
import org.vackapi.mvplearn.retrofitLearn.ApiService;
import org.vackapi.mvplearn.retrofitLearn.RetrofitLearnActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/12.
 */
public class CanKingDetailPresenter {
    private CanKingDetailViewOperater canKingDetailViewOperater;

    public CanKingDetailPresenter(CanKingDetailViewOperater canKingDetailViewOperater) {
        this.canKingDetailViewOperater = canKingDetailViewOperater;
    }

    public void loadData(String id){
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(RetrofitLearnActivity.GET_EARTH_BASE).build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<CanKingDetail> getCanKingItem=apiService.getCanKingDetail(id);
        canKingDetailViewOperater.onStartLoad();
        getCanKingItem.enqueue(new Callback<CanKingDetail>() {
            @Override
            public void onResponse(Call<CanKingDetail> call, Response<CanKingDetail> response) {





                canKingDetailViewOperater.onLoadComplete(response.body());
            }

            @Override
            public void onFailure(Call<CanKingDetail> call, Throwable t) {
                canKingDetailViewOperater.onFail(t);
            }
        });
    }

}
