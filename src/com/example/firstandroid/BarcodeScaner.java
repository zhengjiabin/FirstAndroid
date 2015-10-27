package com.example.firstandroid;

import com.example.barcode.IntentIntegrator;
import com.example.barcode.IntentResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BarcodeScaner extends Activity {
	private TextView tv_result;
	private Button startScaner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.barcode_scaner);

		tv_result = (TextView) findViewById(R.id.text_view_barcode_scaner);
		startScaner = (Button) findViewById(R.id.button_barcode_scaner);

		startScaner.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ���� barcode scaner ɨ������
				IntentIntegrator i = new IntentIntegrator(BarcodeScaner.this);
				i.initiateScan();
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		if (result != null) {
			// ����ɨ����
			tv_result.setText(result.toString());
		} else {
			// ɨ��ʶ��δ�ɹ�
			Toast.makeText(this, "ɨ��ʶ��δ�ɹ�", Toast.LENGTH_SHORT).show();
		}
	}
}
