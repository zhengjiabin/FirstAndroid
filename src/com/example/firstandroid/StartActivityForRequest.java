package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivityForRequest extends Activity {

	private Button returnBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity_for_request);

		returnBtn = (Button) findViewById(R.id.start_activity_for_request_btn);

		returnBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = getIntent();
				String test = intent.getStringExtra("test");
				if (test.equals("wahaha")) {
					Intent intentData = new Intent();
					intentData.putExtra("test", "yiyaya");

					setResult(RESULT_OK, intentData);
					finish();
				} else {
					setResult(RESULT_CANCELED);
					finish();
				}
			}
		});
	}
}
