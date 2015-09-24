package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Button payBtn;
	private Button btnSwitch;
	private Button btnSwith_Rating_seek;

	private ImageView payIv;

	private int[] images = { R.drawable.baozi, R.drawable.ic_launcher };

	private int imageIdx = 0;

	/**
	 * <pre>
	 * activity��һ�α�����ʱ��ִ��onCreate
	 * 1�����ò����ļ�
	 * 2��Ϊ��ť�󶨼������Ⱦ�̬�����ò���
	 * </pre>
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("MainActivity", "onCreateִ�����");

		btnSwitch = (Button) findViewById(R.id.btnSwitch);
		btnSwith_Rating_seek = (Button) findViewById(R.id.btnSwitchActivity_rating_seek);

		payBtn = (Button) findViewById(R.id.btnPay);
		payIv = (ImageView) findViewById(R.id.ivPay);

		payBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imageIdx++;
				if (imageIdx >= images.length) {
					imageIdx = 0;
				}

				payIv.setImageResource(images[imageIdx]);
			}
		});

		btnSwitch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RadioCheckBoxActivity.class);
				startActivity(intent);
			}
		});

		btnSwith_Rating_seek.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, RatingSeekActivity.class);
				startActivity(intent);
			}
		});
	}

	/**
	 * <pre>
	 * onCreateִ����󣬵���Ļ�ɼ�ʱ��ִ��onStart
	 * 1�����ó�ʼ������
	 * </pre>
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("MainActivity", "onStartִ�����");
	}

	/**
	 * <pre>
	 * onStaratִ����󣬵������û�����ʱ��ִ��onResume
	 * 1�������û�������
	 * </pre>
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("MainActivity", "onResumeִ�����");
	}

	/**
	 * <pre>
	 * onResumeִ����󣬵���һ�����ڶ��ڵ�ǰ����ǰ��֮ǰ��ִ��onPause
	 * 1����������activity�����ݡ�ֹͣ����
	 * </pre>
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("MainActivity", "onPauseִ�����");
	}

	/**
	 * <pre>
	 * onPauseִ����󣬵���һ�����ڶ��ڵ�ǰ����ǰ��֮��ִ��onStop
	 * 1����������activity�����ݡ�ֹͣ����
	 * </pre>
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("MainActivity", "onStopִ�����");
	}

	/**
	 * onStopִ�����֮ǰ��ֹͣ����������ִ�У�ִ��onRestart,ִ����󣬻��ٴ�ִ��onStart
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("MainActivity", "onRestartִ�����");
	}

	/**
	 * onStopִ�к󣬵��ر�Ӧ�û��߻���ʱ��ִ��onDestory
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("MainActivity", "onDestroyִ�����");
	}
}
