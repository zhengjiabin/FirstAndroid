package com.example.firstandroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ShowFragment extends Activity {
	private Button changeRightFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_show);
		changeRightFragment = (Button) findViewById(R.id.btn_change_rightfragment);
		changeRightFragment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AnotherRightFragment another = new AnotherRightFragment();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
				beginTransaction.replace(R.id.fl_right, another);
				beginTransaction.addToBackStack(null);
				beginTransaction.commit();
			}
		});
	}

}
