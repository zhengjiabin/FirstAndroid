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
 * �㲥������
 * 
 * <pre>
 * 1����δ���Broadcast Receiver
 *    a���½�һ���̳�BroadcastReceiver����
 *    b����дonReceiver()����
 *    c��ע��㲥
 *    
 * 2��BroadcastReceiver����������
 * 	    ���ù㲥��ʼִ��onReceiver()����ִ�д˷���������10s��,ϵͳ�ᱨ��Ӧ��δ��Ӧ����
 * 
 * 3��ע��㲥����
 *    a����̬ע�᣺androidMainfest.xml
 *    b����̬ע�᣺java����
 * 
 * 4���㲥����
 *    a����ͨ�㲥�����м���ĳ���㲥�Ľ����ߣ������յ��㲥
 *    b������㲥��������������˳����գ����ȼ���intent-filter��priority��������
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
			// �������Ž���
			String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
			Log.i("MyBroadcastReceiver", "�����ڴ�绰��" + phoneNumber);
		} else if ("com.test.broadcast".equals(action)) {
			Bundle extras = intent.getExtras();
			String msg = extras.getString("msg");

			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		} else {
			// �绰����
			Log.i("MyBroadcastReceiver", "�е绰����");
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
			tm.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
		}
	}

	private PhoneStateListener phoneStateListener = new PhoneStateListener() {

		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
//			case TelephonyManager.CALL_STATE_IDLE:
//				Log.i("MyBroadcastReceiver", "�Ҷ�");
//				break;
//			case TelephonyManager.CALL_STATE_OFFHOOK:
//				Log.i("MyBroadcastReceiver", "����");
//				break;
			case TelephonyManager.CALL_STATE_RINGING:
				Log.i("MyBroadcastReceiver", "�е绰���룬������룺" + incomingNumber);
				break;
			default:
				break;
			}
		};
	};

}
