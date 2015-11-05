package com.example.firstandroid;

import com.example.service.BindService.MyBinder;

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

public class BindService extends Activity {

	private Button start, end;
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
		setContentView(R.layout.bind_service);

		start = (Button) findViewById(R.id.bind_start_service);
		end = (Button) findViewById(R.id.bind_end_service);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 启动服务
				Intent intent = new Intent(BindService.this, com.example.service.BindService.class);
				isBind = bindService(intent, connection, BIND_AUTO_CREATE);
			}
		});

		end.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 停止服务
				if (isBind) {
					unbindService(connection);
					isBind = false;
				}
			}
		});
	}
}
