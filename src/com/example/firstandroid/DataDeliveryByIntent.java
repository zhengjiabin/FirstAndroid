package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 使用 intent 传递值
 * @author Administrator
 *
 */
public class DataDeliveryByIntent extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_delivery_intent);
		
		Intent tent = this.getIntent();
		String value = tent.getStringExtra("content");
		Toast.makeText(this, value, Toast.LENGTH_LONG).show();
	}
}
