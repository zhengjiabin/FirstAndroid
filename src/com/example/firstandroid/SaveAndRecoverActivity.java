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
 * ±£´æºÍ»Ö¸´
 * @author Administrator
 *
 */
public class SaveAndRecoverActivity extends Activity{
	
	private EditText content;
	private Button sendButton;
	
	private String value;
	
	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.save_and_recover);
		
		if(savedInstanceState != null){
			value = savedInstanceState.getString("content");
			Toast.makeText(this, value, Toast.LENGTH_SHORT).show();;
		}
		
		
		sendButton = (Button)findViewById(R.id.sendBtn);
		content = (EditText) findViewById(R.id.contentET);
		
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				value = content.getText().toString();
				Intent intent = new Intent();
				intent.putExtra("content", value);
				intent.setClass(SaveAndRecoverActivity.this, DataDeliveryByIntent.class);
				startActivity(intent);
			}
		});
		
		Log.d("SaveAndRecoverActivity", "onCreate");
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
