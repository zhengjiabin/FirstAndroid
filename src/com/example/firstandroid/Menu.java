package com.example.firstandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;

public class Menu extends Activity implements OnMenuItemClickListener{
	
	private TextView contextMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		contextMenu = (TextView) findViewById(R.id.ContextMenu);
		registerForContextMenu(contextMenu);
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.activity_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if(id == R.id.action_settings){
			//处理单机响应
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.activity_menu, menu);
	}
	

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		return false;
	}

}
