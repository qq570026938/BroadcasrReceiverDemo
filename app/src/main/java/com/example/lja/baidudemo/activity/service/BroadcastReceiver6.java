package com.example.lja.baidudemo.activity.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 权限高的广播接收者:可以修改广播,甚至可以终止广播:
 */

public class BroadcastReceiver6 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        //获取广播的数据
        String data = getResultData();
        Toast.makeText(context, "BroadcastReceiver6-->"+data, Toast.LENGTH_SHORT).show();
        setResultData("6修改了数据");

    }

}
