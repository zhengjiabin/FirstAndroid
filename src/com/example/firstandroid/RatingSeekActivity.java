package com.example.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TimePicker;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;

public class RatingSeekActivity extends Activity {
	private RatingBar rb_grade;

	private SeekBar sb_process;

	private TextView tv_process;

	private ImageButton ib_timeout;

	private ProgressBar pb_timeout;

	private DatePicker dp_date;
	private TimePicker tp_time;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rating_seek);

		rb_grade = (RatingBar) findViewById(R.id.rb_grade);
		sb_process = (SeekBar) findViewById(R.id.sb_process);
		tv_process = (TextView) findViewById(R.id.tv_process);
		ib_timeout = (ImageButton) findViewById(R.id.ib_timeout);
		pb_timeout = (ProgressBar) findViewById(R.id.pb_timeout);
		dp_date = (DatePicker) findViewById(R.id.dp_date);
		tp_time = (TimePicker) findViewById(R.id.tp_time);

		rb_grade.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				Toast.makeText(RatingSeekActivity.this, "您给自己的评分是：" + rating,
						Toast.LENGTH_SHORT).show();

			}
		});

		sb_process.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				tv_process.setText("工作进度" + "：" + progress);
			}
		});

		ib_timeout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pb_timeout.setVisibility(View.VISIBLE);

				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});

				thread.start();
			}
		});

		dp_date.setCalendarViewShown(false);
		dp_date.init(2015, 8, 23, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				Toast.makeText(
						RatingSeekActivity.this,
						"你选择的日期为：" + year + "-" + (monthOfYear + 1) + "-"
								+ dayOfMonth, Toast.LENGTH_SHORT).show();
			}
		});

		tp_time.setIs24HourView(true);
		tp_time.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				Toast.makeText(RatingSeekActivity.this,
						hourOfDay + "-" + minute, Toast.LENGTH_SHORT).show();
				;

			}
		});
	}
}
