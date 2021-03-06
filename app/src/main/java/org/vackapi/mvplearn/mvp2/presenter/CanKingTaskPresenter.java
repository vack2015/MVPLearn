package org.vackapi.mvplearn.mvp2.presenter;

import org.vackapi.mvplearn.mvp2.moudle.CanKingItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface CanKingTaskPresenter {
    void addItem(int page);
    ArrayList<CanKingItem> getItemList();
    void showNoMore();
    void onLoading();
    void showDataError(Exception e);
    void onItemAdding();
    void onItemAdded();
    void onLoadComplete(int currentPage,int totalPage);
}
