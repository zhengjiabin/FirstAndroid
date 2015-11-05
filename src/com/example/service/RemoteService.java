package com.example.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RemoteService extends Service {
	private NotificationManager manager;

	public class ForeBinder extends Binder {
		public RemoteService getService() {
			return RemoteService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return new ForeBinder();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		super.onCreate();
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification.Builder nb = new Notification.Builder(this);
		nb.setContentTitle("��ʾ");
		nb.setContentText("������Է�����ʺ�");
		manager.notify(100, nb.getNotification());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		manager.cancelAll();
	}
}
