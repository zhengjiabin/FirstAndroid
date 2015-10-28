package com.example.firstandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ThreadActivity extends Activity implements Runnable {
	private ProgressDialog progress;
	private Button thread_main, thread1, thread2, thread3;

	private OnClickListener listener;

	/** 自定义消息常量 */
	private static final int STOP = 1;

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == STOP) {
				progress.dismiss();
				Toast.makeText(ThreadActivity.this, "加载完毕", Toast.LENGTH_SHORT).show();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread);

		listener = new ThreadButtonListener();

		thread_main = (Button) findViewById(R.id.thread_main);
		thread1 = (Button) findViewById(R.id.thread1);
		thread2 = (Button) findViewById(R.id.thread2);
		thread3 = (Button) findViewById(R.id.thread3);

		thread_main.setOnClickListener(listener);
		thread1.setOnClickListener(listener);
		thread2.setOnClickListener(listener);
		thread3.setOnClickListener(listener);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Message msg = new Message();
		msg.what = STOP;
		handler.sendMessage(msg);
	}

	public class ThreadButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.thread_main:
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case R.id.thread1:
				// 显示加载对话框
				progress = ProgressDialog.show(ThreadActivity.this, "提示", "创建线程方式一，加载中。。。", true, true);
				LoadingThread loadingThread = new LoadingThread();
				loadingThread.start();
				break;
			case R.id.thread2:
				progress = ProgressDialog.show(ThreadActivity.this, "提示", "创建线程方式二，加载中。。。", true, true);
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Message msg = new Message();
						msg.what = STOP;
						handler.sendMessage(msg);
					}
				});
				thread.start();
				break;
			case R.id.thread3:
				progress = ProgressDialog.show(ThreadActivity.this, "提示", "创建线程方式三，加载中。。。", true, true);
				Thread t = new Thread(ThreadActivity.this);
				t.start();
				break;

			default:
				break;
			}
		}
	}

	private class LoadingThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Message msg = new Message();
			msg.what = STOP;
			handler.sendMessage(msg);
		}
	}
}
