package org.vackapi.mvplearn.mvp2;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface CanKingViewOperater {
    void onLoading();
    void onItemAdding();
    void onItemAdded();
    void onItemClick(int position);
    void onLoadComplete(int currentPage,int totalPage);
    void showNoMore();
    void showDataError(Exception e);
    CanKingItemAdapter getAdapter();
}
