package com.example.lja.baidudemo.activity.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 每次接收广播都会生成新的BroadcastReceiver1，当处理完onReceive方法后就不会再被使用
 * 再次接收就在生成新的BroadcastReceiver1对象
 */

public class BroadcastReceiver4 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        //获取广播的数据
        String data = getResultData();
        Toast.makeText(context, "BroadcastReceiver4-->"+data, Toast.LENGTH_SHORT).show();
    }
}
