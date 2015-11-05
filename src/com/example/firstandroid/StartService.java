package com.example.firstandroid;

import com.example.service.Service01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 启动型服务
 * @author Administrator
 *
 */
public class StartService extends Activity {
	private Button start, end;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_service);

		start = (Button) findViewById(R.id.start_service);
		end = (Button) findViewById(R.id.end_service);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 启动服务
				Intent intent = new Intent(StartService.this, Service01.class);
				startService(intent);
			}
		});

		end.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 停止服务
				Intent intent = new Intent(StartService.this, Service01.class);
				stopService(intent);
			}
		});
	}
}
