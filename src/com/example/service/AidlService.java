package com.example.service;

import com.example.firstandroid.IMyservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AidlService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new MyServiceIml();
	}

	public class MyServiceIml extends IMyservice.Stub {
		@Override
		public String getValue() {
			return "i am from Remote service";
		}
	}
}
