package org.vackapi.mvplearn.retrofitLearn;

import org.vackapi.mvplearn.mvp2.moudle.CanKingDetail;
import org.vackapi.mvplearn.mvp2.moudle.CanKingList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface ApiService {
    @GET("getearth_list")
    Call<CanKingList> getCanKingList(@Query("page") String page);

    @GET("getearth_single")
    Call<CanKingDetail> getCanKingDetail(@Query("id") String id);
}
