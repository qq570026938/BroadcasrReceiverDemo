package com.example.lja.baidudemo.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lja.baidudemo.R;
import com.example.lja.baidudemo.activity.service.BroadcastReceiver4;
import com.example.lja.baidudemo.activity.service.BroadcastReceiver5;
import com.example.lja.baidudemo.activity.service.DemoReceiver;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edt_msg;
    private Button btn_send;
    private Button btn_send2;
    private Button btn_send_order;
    private DemoReceiver receiver;
//    private BroadcastReceiver receiver;
    public static String s = "1";
    public static String SEND_BROAD="DEMO_RECEIVER";//动态注册标志
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();

    }

    private void setListener() {
        btn_send.setOnClickListener(this);
        btn_send2.setOnClickListener(this);
        btn_send_order.setOnClickListener(this);
    }

    private void initView() {
        edt_msg = (EditText) findViewById(R.id.edt_msg);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send2 = (Button) findViewById(R.id.btn_send2);
        btn_send_order= (Button) findViewById(R.id.btn_send_order);
    }


    @Override
    public void onClick(View v) {
        s = edt_msg.getText().toString();
        switch (v.getId()){
            case R.id.btn_send:
                senBroadcastReceiver();
                break;
            case R.id.btn_send2:
                //                静态注册
                Intent intent = new Intent();
                intent.setAction("android.intent.action.HHHH");
                intent.putExtra("静态注册","添加的内容");
                /**无序广播（同步广播）：发送方发出后，几乎同时到达多个广播接收者处，
                某个接收者不能接收到广播后进行一番处理后传给下一个接收者，
                并且无法终止广播继续传播；Context.sendBroadcast(intent);
                 **/
                sendBroadcast(intent);
                break;
            case R.id.btn_send_order:
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.order");
               /** 有序广播：广播接收者需要提前设置优先级
                ，优先级高的先接收到广播，优先级数值为-1000~1000，
                在AndroidManifest.xml的<intent-filter android:priority="xxx">
                ，当A收到广播后，可以向广播中添加一些数据给下一个接收者(intent.putExtra())
                ，或者终止广播(abortBroadcast())；Context.sendOrderedBroadcast(intent);
                **/
                sendOrderedBroadcast(intent2,//意图动作,指定action动作
                                        null, //receiverPermission,接收这条广播具备什么权限
                                    new BroadcastReceiver4(),//resultReceiver,最终的广播接受者,广播一定会传给他，无论中间是否被终止
                                   null, //scheduler,handler对象处理广播的分发
                                   0,//initialCode,初始代码
                                   "每人发10斤大米,不得有误!", //initialData,初始数据
                        null//initialExtras,额外的数据,如果觉得初始数据不够,可以通过bundle来指定其他数据
                                );
                break;
        }




    }
    /**1.动态注册：绑定广播**/
    private void bandBroadcastReceiver(){
        receiver = new DemoReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(SEND_BROAD);
        this.registerReceiver(receiver,filter);
    }
    /**2.模拟发送一个广播**/
    private void senBroadcastReceiver(){
        Intent intent = new Intent();
        intent.setAction(SEND_BROAD);
        sendBroadcast(intent);
    }
    /**3.解除广播接受者**/
    private void unBandBroadcastReciver(){
        this.unregisterReceiver(receiver);
    }
    @Override
    protected void onResume() {
        bandBroadcastReceiver();
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        unBandBroadcastReciver();
        super.onDestroy();
    }
}
