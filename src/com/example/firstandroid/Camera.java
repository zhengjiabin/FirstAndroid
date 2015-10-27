package com.example.firstandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends Activity {

	private ImageView show_photo;
	private Button take_photo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);

		show_photo = (ImageView) findViewById(R.id.imageview_show_photo);
		take_photo = (Button) findViewById(R.id.button_camera);

		take_photo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 100);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 100) {
			if (RESULT_OK == resultCode) {
				Bundle extras = data.getExtras();
				Bitmap bitmap = (Bitmap) extras.get("data");
				
				show_photo.setImageBitmap(bitmap);
			} else if (RESULT_CANCELED == resultCode) {
				Toast toast = Toast.makeText(this, "≈ƒ’’ ß∞‹", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}
}
