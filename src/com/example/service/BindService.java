package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 绑定型服务
 * 
 * @author Administrator
 *
 */
public class BindService extends Service {
	@Override
	public void onCreate() {
		Log.i(this.getClass().getName(), "onCreate");
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(this.getClass().getName(), "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(this.getClass().getName(), "onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Log.i(this.getClass().getName(), "onDestroy");
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(this.getClass().getName(), "onBind");

		Binder binder = new MyBinder();
		return binder;
	}

	public class MyBinder extends Binder {
		public void startDownload() {
			Log.i(this.getClass().getName(), "BindService准备下载");
		}
	}
}
