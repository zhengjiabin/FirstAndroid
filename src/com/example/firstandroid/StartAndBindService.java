package com.example.firstandroid;

import com.example.service.StartAndBindService.MyBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * start和bind同时启动
 * 
 * @author Administrator
 *
 */
public class StartAndBindService extends Activity {

	private Button start, stop, bind, unBind;
	private boolean isBind = false;

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(this.getClass().getName(), "onServiceDisconnected");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(this.getClass().getName(), "onServiceConnected");
			MyBinder binder = (MyBinder) service;
			binder.startDownload();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_and_bind_service);

		start = (Button) findViewById(R.id.start_and_bind_start_service);
		stop = (Button) findViewById(R.id.start_and_bind_stop_service);
		bind = (Button) findViewById(R.id.start_and_bind_bind_service);
		unBind = (Button) findViewById(R.id.start_and_bind_unBind_service);

		ButtonOnClickListener listener = new ButtonOnClickListener();
		start.setOnClickListener(listener);
		stop.setOnClickListener(listener);
		bind.setOnClickListener(listener);
		unBind.setOnClickListener(listener);
	}

	private class ButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = null;

			switch (v.getId()) {
			case R.id.start_and_bind_start_service:
				intent = new Intent(StartAndBindService.this, com.example.service.StartAndBindService.class);
				startService(intent);
				break;
			case R.id.start_and_bind_stop_service:
				intent = new Intent(StartAndBindService.this, com.example.service.StartAndBindService.class);
				stopService(intent);
				break;
			case R.id.start_and_bind_bind_service:
				intent = new Intent(StartAndBindService.this, com.example.service.StartAndBindService.class);
				isBind = bindService(intent, connection, BIND_AUTO_CREATE);
				break;
			case R.id.start_and_bind_unBind_service:
				// 停止服务
				if (isBind) {
					unbindService(connection);
					isBind = false;
				}
				break;
			}
		}

	}
}
