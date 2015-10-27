package com.example.firstandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 保存和恢复
 * 
 * @author Administrator
 *
 */
public class SaveAndRecoverActivity extends Activity {

	private EditText content;
	private Button sendButton;

	private Button returnBtn;

	private String value;

	private static final int REQUESTCODE = 100;

	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_and_recover);

		if (savedInstanceState != null) {
			value = savedInstanceState.getString("content");
			Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
			;
		}

		sendButton = (Button) findViewById(R.id.sendBtn);
		content = (EditText) findViewById(R.id.contentET);

		sendButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				value = content.getText().toString();
				Intent intent = new Intent();

				// intent.putExtra("content", value);

				Bundle bundle = new Bundle();
				bundle.putString("test", value);
				intent.putExtras(bundle);

				intent.setClass(SaveAndRecoverActivity.this, DataDeliveryByBundle.class);
				startActivity(intent);
			}
		});

		returnBtn = (Button) findViewById(R.id.returnBtn);
		returnBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				value = content.getText().toString();
				Intent intent = new Intent(SaveAndRecoverActivity.this, StartActivityForRequest.class);
				intent.putExtra("test", value);

				startActivityForResult(intent, REQUESTCODE);
			}
		});

		Log.d("SaveAndRecoverActivity", "onCreate");
	}

	@SuppressLint("ShowToast")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (REQUESTCODE == requestCode) {
			if (RESULT_OK == resultCode) {
				if (data != null) {
					String value = data.getStringExtra("test");
					Toast toast = Toast.makeText(this, value, Toast.LENGTH_LONG);
					toast.show();
				} else {
					Toast toast = Toast.makeText(this, "成功了，但未修改", Toast.LENGTH_SHORT);
					toast.show();
				}
			} else if (RESULT_CANCELED == resultCode) {
				Toast toast = Toast.makeText(this, "失败了", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("SaveAndRecoverActivity", "onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("SaveAndRecoverActivity", "onResume");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SaveAndRecoverActivity", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SaveAndRecoverActivity", "onDestroy");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("SaveAndRecoverActivity", "onRestart");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("SaveAndRecoverActivity", "onPause");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		Log.d("SaveAndRecoverActivity", "onPostResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("SaveAndRecoverActivity", "onSaveInstanceState");

		value = content.getText().toString();
		outState.putString("content", value);
	}

}
