package org.vackapi.mvplearn.mvp2.moudle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/2.
 */
public class CanKingFactory {
    private ArrayList<CanKingItem> data=new ArrayList<>();

    public void addItem(ArrayList<CanKingItem> items){
        data.addAll(items);
    }

    public ArrayList<CanKingItem> getData(){
        return data;
    }
}
