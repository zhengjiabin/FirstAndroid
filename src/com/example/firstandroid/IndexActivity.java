package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IndexActivity extends Activity {
	private Button mainActivity;
	private Button radioCheckBoxActivity;
	private Button ratingSeekActivity;
	private Button saveAndRecover;
	private Button camera;
	private Button sendBroadcast;
	private Button dynamicRegisterBroadcastReceiver;
	private Button barcodeScaner;
	private Button thread;
	private Button startService;
	private Button bindService;
	private Button startAndBindService;
	private Button remoteService;
	private Button menu;
	private Button fragment;
	private ButtonOnClickListener buttonOnClickListener;
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);

		mainActivity = (Button) findViewById(R.id.mainActivity);
		radioCheckBoxActivity = (Button) findViewById(R.id.radioCheckBoxActivity);
		ratingSeekActivity = (Button) findViewById(R.id.ratingSeekActivity);
		saveAndRecover = (Button) findViewById(R.id.saveAndRecover);
		camera = (Button) findViewById(R.id.camera);
		sendBroadcast = (Button) findViewById(R.id.sendBroadcast);
		dynamicRegisterBroadcastReceiver = (Button) findViewById(R.id.dynamicRegisterBroadcastReceiver);
		barcodeScaner = (Button) findViewById(R.id.barcodeScaner);
		thread = (Button) findViewById(R.id.thread);
		startService = (Button) findViewById(R.id.switch_start_service);
		bindService = (Button) findViewById(R.id.switch_bind_service);
		startAndBindService = (Button) findViewById(R.id.switch_start_and_bind_service);
		remoteService = (Button) findViewById(R.id.switch_remote_service);
		menu = (Button) findViewById(R.id.switch_menu);
		fragment = (Button) findViewById(R.id.switch_fragment);

		buttonOnClickListener = new ButtonOnClickListener();
		mainActivity.setOnClickListener(buttonOnClickListener);
		radioCheckBoxActivity.setOnClickListener(buttonOnClickListener);
		ratingSeekActivity.setOnClickListener(buttonOnClickListener);
		saveAndRecover.setOnClickListener(buttonOnClickListener);
		camera.setOnClickListener(buttonOnClickListener);
		sendBroadcast.setOnClickListener(buttonOnClickListener);
		dynamicRegisterBroadcastReceiver.setOnClickListener(buttonOnClickListener);
		barcodeScaner.setOnClickListener(buttonOnClickListener);
		thread.setOnClickListener(buttonOnClickListener);
		startService.setOnClickListener(buttonOnClickListener);
		bindService.setOnClickListener(buttonOnClickListener);
		startAndBindService.setOnClickListener(buttonOnClickListener);
		remoteService.setOnClickListener(buttonOnClickListener);
		menu.setOnClickListener(buttonOnClickListener);
		fragment.setOnClickListener(buttonOnClickListener);
	}

	private class ButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = null;

			switch (v.getId()) {
			case R.id.mainActivity:
				intent = new Intent(IndexActivity.this, MainActivity.class);
				break;
			case R.id.radioCheckBoxActivity:
				intent = new Intent(IndexActivity.this, RadioCheckBoxActivity.class);
				break;
			case R.id.ratingSeekActivity:
				intent = new Intent(IndexActivity.this, RatingSeekActivity.class);
				break;
			case R.id.saveAndRecover:
				intent = new Intent(IndexActivity.this, SaveAndRecoverActivity.class);
				break;
			case R.id.camera:
				intent = new Intent(IndexActivity.this, Camera.class);
				break;
			case R.id.sendBroadcast:
				intent = new Intent(IndexActivity.this, SendBroadcast.class);
				break;
			case R.id.dynamicRegisterBroadcastReceiver:
				intent = new Intent(IndexActivity.this, DynamicRegisterBroadcastReceiver.class);
				break;
			case R.id.barcodeScaner:
				intent = new Intent(IndexActivity.this, BarcodeScaner.class);
				break;
			case R.id.thread:
				intent = new Intent(IndexActivity.this, ThreadActivity.class);
				break;
			case R.id.switch_start_service:
				intent = new Intent(IndexActivity.this, StartService.class);
				break;
			case R.id.switch_bind_service:
				intent = new Intent(IndexActivity.this, BindService.class);
				break;
			case R.id.switch_start_and_bind_service:
				intent = new Intent(IndexActivity.this, StartAndBindService.class);
				break;
			case R.id.switch_remote_service:
				intent = new Intent(IndexActivity.this, RemoteService.class);
				break;
			case R.id.switch_menu:
				intent = new Intent(IndexActivity.this, Menu.class);
				break;
			case R.id.switch_fragment:
				intent = new Intent(IndexActivity.this, ShowFragment.class);
				break;
			}

			startActivity(intent);
		}

	}

	/**
	 * 测试退出应用功能
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 应用程序退出方式一：确认退出对话框

		// if (keyCode == KeyEvent.KEYCODE_BACK) {
		// Builder builder = new AlertDialog.Builder(this);
		// builder.setTitle("退出");
		// builder.setMessage("确认退出当前应用？");
		//
		// builder.setPositiveButton("确认", new DialogInterface.OnClickListener()
		// {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// finish();
		// }
		// });
		//
		// builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
		// {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		// return;
		// }
		// });
		//
		// builder.show();
		// }

		// 应用程序退出方式二：连续按两次确认退出
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			long currentTime = System.currentTimeMillis();
			if ((currentTime - exitTime) > 2000) {
				Toast.makeText(this, "再按一次确认退出", Toast.LENGTH_SHORT).show();
				exitTime = currentTime;
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
}
