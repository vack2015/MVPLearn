package org.vackapi.mvplearn.mvp2;

import org.vackapi.mvplearn.mvp2.moudle.CanKingDetail;

/**
 * Created by Administrator on 2016/8/12.
 */
public interface CanKingDetailViewOperater {
    void onStartLoad();
    void onLoadComplete(CanKingDetail canKingDetail);
    void onFail(Throwable e);
}
