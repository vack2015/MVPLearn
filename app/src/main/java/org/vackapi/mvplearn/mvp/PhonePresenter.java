package org.vackapi.mvplearn.mvp;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2016/7/29.
 */
public class PhonePresenter  implements TaskPresenter{
    private final PhoneFactory phoneFactory;
    private final OperationView operationView;

    private static final int CREATE_PHONE_TIME=2000;
    private static final int  MSG_WHAT=0X001;

    public PhonePresenter(PhoneFactory phoneFactory, OperationView operationView) {
        this.phoneFactory = phoneFactory;
        this.operationView = operationView;
    }

    @Override
    public void addPhone(Phone phone) {
        operationView.showCreatingPhone();
        if(handler.hasMessages(MSG_WHAT)){
            operationView.showFactoryBusy();
            return;
        }
        Message message=new Message();
        message.what=MSG_WHAT;
        message.obj=phone;
        handler.sendMessageDelayed(message,CREATE_PHONE_TIME);
        operationView.showCreatingPhone();
    }

    @Override
    public boolean removePhone(Phone phone) {
        boolean res=phoneFactory.removePhone(phone);
        if (phoneFactory.getPhonCount() <= 0) {
            operationView.showNoPhone();
        }
        operationView.showPhoneCountChange();
        return res;
    }

    @Override
    public Phone removePhone(int index) {
        Phone res=phoneFactory.removePhone(index);
        if (phoneFactory.getPhonCount() <= 0) {
            operationView.showNoPhone();
        }
        operationView.showPhoneCountChange();
        return res;
    }

    @Override
    public ArrayList<Phone> getPhonesList() {
        return phoneFactory.getPhoneList();
    }

    @Override
    public void addRandomPhone() {
        addPhone(new Phone("iphone", 4000 + new Random().nextInt(1000)));
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==MSG_WHAT){
                phoneFactory.addPhone((Phone)msg.obj);
                operationView.showCreatedPhone();
                operationView.showPhoneCountChange();
            }
        }
    };
}
