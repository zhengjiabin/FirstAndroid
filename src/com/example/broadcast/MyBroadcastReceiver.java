package com.example.broadcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * 广播接收器
 * 
 * <pre>
 * 1、如何创建Broadcast Receiver
 *    a、新建一个继承BroadcastReceiver的类
 *    b、重写onReceiver()方法
 *    c、注册广播
 *    
 * 2、BroadcastReceiver的生命周期
 * 	    调用广播开始执行onReceiver()，若执行此方法过长（10s）,系统会报出应用未响应错误
 * 
 * 3、注册广播方法
 *    a、静态注册：androidMainfest.xml
 *    b、动态注册：java代码
 * 
 * 4、广播类型
 *    a、普通广播：所有监听某个广播的接收者，都能收到广播
 *    b、有序广播：按接收者优先顺序接收，优先级在intent-filter中priority属性设置
 * </pre>
 * 
 * @author Administrator
 *
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (Intent.ACTION_NEW_OUTGOING_CALL.equals(action)) {
			// 调出拨号界面
			String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
			Log.i("MyBroadcastReceiver", "有人在打电话：" + phoneNumber);
		} else if ("com.test.broadcast".equals(action)) {
			Bundle extras = intent.getExtras();
			String msg = extras.getString("msg");

			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		} else {
			// 电话呼入
			Log.i("MyBroadcastReceiver", "有电话呼入");
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
			tm.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
		}
	}

	private PhoneStateListener phoneStateListener = new PhoneStateListener() {

		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
//			case TelephonyManager.CALL_STATE_IDLE:
//				Log.i("MyBroadcastReceiver", "挂断");
//				break;
//			case TelephonyManager.CALL_STATE_OFFHOOK:
//				Log.i("MyBroadcastReceiver", "接听");
//				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Log.i("MyBroadcastReceiver", "有电话呼入，来电号码：" + incomingNumber);
				break;
			default:
				break;
			}
		};
	};

}
