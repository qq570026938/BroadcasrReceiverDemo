package com.example.lja.baidudemo.activity.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 每次接收广播都会生成新的BroadcastReceiver1，当处理完onReceive方法后就不会再被使用
 * 再次接收就在生成新的BroadcastReceiver1对象
 */

public class BroadcastReceiver5 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = getResultData();
        Toast.makeText(context, "BroadcastReceiver5-->"+data, Toast.LENGTH_SHORT).show();
        setResultData("5修改了数据");
        //终止广播
        abortBroadcast();
    }
}
