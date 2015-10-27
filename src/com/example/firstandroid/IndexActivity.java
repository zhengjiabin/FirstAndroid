package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends Activity {
	private Button mainActivity;
	private Button radioCheckBoxActivity;
	private Button ratingSeekActivity;
	private Button saveAndRecover;
	private Button camera;
	private Button sendBroadcast;
	private Button dynamicRegisterBroadcastReceiver;
	private ButtonOnClickListener buttonOnClickListener;

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

		buttonOnClickListener = new ButtonOnClickListener();
		mainActivity.setOnClickListener(buttonOnClickListener);
		radioCheckBoxActivity.setOnClickListener(buttonOnClickListener);
		ratingSeekActivity.setOnClickListener(buttonOnClickListener);
		saveAndRecover.setOnClickListener(buttonOnClickListener);
		camera.setOnClickListener(buttonOnClickListener);
		sendBroadcast.setOnClickListener(buttonOnClickListener);
		dynamicRegisterBroadcastReceiver.setOnClickListener(buttonOnClickListener);
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
			}

			startActivity(intent);
		}

	}
}
