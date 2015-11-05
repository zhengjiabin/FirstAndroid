package com.example.firstandroid;

import com.example.service.AidlService;
import com.example.service.RemoteService.ForeBinder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * Ô¶³Ì·þÎñ
 * 
 * @author Administrator
 *
 */
public class RemoteService extends Activity {

	private Button bindAIDL;
	private Button callAIDL;
	private Button cancelAIDL;

	private Button startService;
	private Button stopService;

	private boolean isBind = false;
	private boolean isBindFore = false;
	
	private IMyservice myService;
	@SuppressWarnings("unused")
	private com.example.service.RemoteService remoteService;

	private ButtonOnClickListener listener = new ButtonOnClickListener();

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			myService = IMyservice.Stub.asInterface(service);
			callAIDL.setEnabled(true);
		}
	};

	private ServiceConnection foreConnetion = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			ForeBinder binder = (ForeBinder) service;
			remoteService = binder.getService();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remote_service);
		bindAIDL = (Button) findViewById(R.id.bing_aidl_service);
		callAIDL = (Button) findViewById(R.id.call_aidl_service);
		cancelAIDL = (Button) findViewById(R.id.cancel_bind_aidl_service);
		startService = (Button) findViewById(R.id.start_reception_service);
		stopService = (Button) findViewById(R.id.stop_reception_service);

		bindAIDL.setOnClickListener(listener);
		callAIDL.setOnClickListener(listener);
		cancelAIDL.setOnClickListener(listener);
		startService.setOnClickListener(listener);
		stopService.setOnClickListener(listener);
	}

	private class ButtonOnClickListener implements OnClickListener {

		@SuppressLint("ShowToast")
		@Override
		public void onClick(View v) {
			Intent intent = null;

			switch (v.getId()) {
			case R.id.bing_aidl_service:
				intent = new Intent(RemoteService.this, AidlService.class);
				isBind = bindService(intent, connection, BIND_AUTO_CREATE);
				callAIDL.setEnabled(true);
				break;
			case R.id.call_aidl_service:
				try {
					String aidl = myService.getValue();
					Toast.makeText(RemoteService.this, aidl, Toast.LENGTH_SHORT);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			case R.id.cancel_bind_aidl_service:
				if (isBind) {
					unbindService(connection);
					myService = null;
					callAIDL.setEnabled(false);
					isBind = false;
					Toast.makeText(RemoteService.this, "cancel", Toast.LENGTH_SHORT);
				}
				break;
			case R.id.start_reception_service:
				intent = new Intent(RemoteService.this, com.example.service.RemoteService.class);
				isBindFore = bindService(intent, foreConnetion, BIND_AUTO_CREATE);
				break;
			case R.id.stop_reception_service:
				if (isBindFore) {
					unbindService(foreConnetion);
					isBindFore = false;
				}
				break;
			}
		}
	}
}
