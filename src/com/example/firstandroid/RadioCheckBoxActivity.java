package com.example.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RadioCheckBoxActivity extends Activity {
	private RadioGroup sex;
	private CheckBox basketball;
	private CheckBox football;
	private CheckBox swim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_checkbox);

		sex = (RadioGroup) findViewById(R.id.rgsex);

		basketball = (CheckBox) findViewById(R.id.cb_baseketball);
		football = (CheckBox) findViewById(R.id.cb_football);
		swim = (CheckBox) findViewById(R.id.cb_swim);

		sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rbman:
					Toast.makeText(RadioCheckBoxActivity.this, "ÄãÑ¡Ôñ£ºÄÐ",
							Toast.LENGTH_SHORT).show();
					break;
				case R.id.rbwoman:
					Toast.makeText(RadioCheckBoxActivity.this, "ÄãÑ¡Ôñ£ºÅ®",
							Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
				}
			}
		});

		basketball
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							Toast.makeText(RadioCheckBoxActivity.this,
									"ÄãÑ¡Ôñ£ºÀºÇò", Toast.LENGTH_SHORT).show();
						}
					}
				});

		swim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					Toast.makeText(RadioCheckBoxActivity.this, "ÄãÑ¡Ôñ£ºÓÎÓ¾",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					Toast.makeText(RadioCheckBoxActivity.this, "ÄãÑ¡Ôñ£º×ãÇò",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
