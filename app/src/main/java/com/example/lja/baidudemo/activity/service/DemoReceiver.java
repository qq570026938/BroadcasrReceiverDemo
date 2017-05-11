package com.example.lja.baidudemo.activity.service;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.lja.baidudemo.activity.MainActivity;

/**
 * Created by LJA on 2017/5/11.
 */

public class DemoReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "DemoReceiver-->"+MainActivity.s, Toast.LENGTH_SHORT).show();
    }
}
