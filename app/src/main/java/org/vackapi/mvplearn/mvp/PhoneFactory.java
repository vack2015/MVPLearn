package org.vackapi.mvplearn.mvp;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/28.
 */
public class PhoneFactory {
    private ArrayList<Phone> phoneList=new ArrayList<>();

    public void addPhone(Phone phone){
            phoneList.add(phone);
    }
    public boolean removePhone(Phone phone){
        return phoneList.remove(phone);
    }

    public Phone removePhone(int position){
        if(position<phoneList.size()&&position>=0){
            return phoneList.remove(position);
        }
        return null;
    }

    public void createPhone(String name,double price){
        Phone phone=new Phone(name,price);
        phoneList.add(phone);
    }
    public ArrayList<Phone> getPhoneList(){
        return phoneList;
    }
    public int getPhonCount(){
        return phoneList.size();
    }


}
