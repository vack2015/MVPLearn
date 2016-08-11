package org.vackapi.mvplearn.mvp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/29.
 */
public interface TaskPresenter {
    void addPhone(Phone phone);

    boolean removePhone(Phone phone);

    Phone removePhone(int index);

    ArrayList<Phone> getPhonesList();

    void addRandomPhone();
}
