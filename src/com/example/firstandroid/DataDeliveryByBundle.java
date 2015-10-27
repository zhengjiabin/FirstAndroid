package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 使用 bundle 传递值
 * @author Administrator
 *
 */
public class DataDeliveryByBundle extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_delivery_bundle);
		
		Intent tent = this.getIntent();
		Bundle bundle = tent.getExtras();
		String value = bundle.getString("test");
		Toast.makeText(this, value, Toast.LENGTH_LONG).show();
	}
}
