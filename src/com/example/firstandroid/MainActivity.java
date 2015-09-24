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
	 * activity第一次被创建时，执行onCreate
	 * 1、设置布局文件
	 * 2、为按钮绑定监听器等静态的设置操作
	 * </pre>
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("MainActivity", "onCreate执行完毕");

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
	 * onCreate执行完后，当屏幕可见时，执行onStart
	 * 1、设置初始化配置
	 * </pre>
	 */
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("MainActivity", "onStart执行完毕");
	}

	/**
	 * <pre>
	 * onStarat执行完后，当可与用户操作时，执行onResume
	 * 1、参与用户操作等
	 * </pre>
	 */
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("MainActivity", "onResume执行完毕");
	}

	/**
	 * <pre>
	 * onResume执行完后，当有一个窗口顶在当前窗口前面之前，执行onPause
	 * 1、保存现有activity的数据、停止动画
	 * </pre>
	 */
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("MainActivity", "onPause执行完毕");
	}

	/**
	 * <pre>
	 * onPause执行完后，当有一个窗口顶在当前窗口前面之后，执行onStop
	 * 1、保存现有activity的数据、停止动画
	 * </pre>
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("MainActivity", "onStop执行完毕");
	}

	/**
	 * onStop执行完后，之前被停止，现在重新执行，执行onRestart,执行完后，会再次执行onStart
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("MainActivity", "onRestart执行完毕");
	}

	/**
	 * onStop执行后，当关闭应用或者回收时，执行onDestory
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("MainActivity", "onDestroy执行完毕");
	}
}
