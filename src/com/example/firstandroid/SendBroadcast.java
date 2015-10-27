package com.example.firstandroid;

import com.example.firstandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * ·¢ËÍ¹ã²¥
 * 
 * @author Administrator
 *
 */
public class SendBroadcast extends Activity {
	private EditText editText_send;
	private Button button_send;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_broadcast);

		editText_send = (EditText) findViewById(R.id.edit_text_send_broadcast);
		button_send = (Button) findViewById(R.id.button_send_broadcast);

		button_send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String msg = editText_send.getText().toString();
				
				Intent intent = new Intent();
				intent.setAction("com.test.broadcast");
				intent.putExtra("msg", msg);
				sendBroadcast(intent);
			}
		});
	}
}
