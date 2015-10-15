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
	private ButtonOnClickListener buttonOnClickListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);

		mainActivity = (Button) findViewById(R.id.mainActivity);
		radioCheckBoxActivity = (Button) findViewById(R.id.radioCheckBoxActivity);
		ratingSeekActivity = (Button) findViewById(R.id.ratingSeekActivity);
		saveAndRecover = (Button) findViewById(R.id.saveAndRecover);

		buttonOnClickListener = new ButtonOnClickListener();
		mainActivity.setOnClickListener(buttonOnClickListener);
		radioCheckBoxActivity.setOnClickListener(buttonOnClickListener);
		ratingSeekActivity.setOnClickListener(buttonOnClickListener);
		saveAndRecover.setOnClickListener(buttonOnClickListener);
	}

	private class ButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.mainActivity:
				Intent i1 = new Intent(IndexActivity.this, MainActivity.class);
				startActivity(i1);
				break;
			case R.id.radioCheckBoxActivity:
				Intent i2 = new Intent(IndexActivity.this, RadioCheckBoxActivity.class);
				startActivity(i2);
				break;
			case R.id.ratingSeekActivity:
				Intent i3 = new Intent(IndexActivity.this, RatingSeekActivity.class);
				startActivity(i3);
				break;
			case R.id.saveAndRecover:
				Intent i4 = new Intent(IndexActivity.this, SaveAndRecoverActivity.class);
				startActivity(i4);
				break;
			}
		}

	}
}
