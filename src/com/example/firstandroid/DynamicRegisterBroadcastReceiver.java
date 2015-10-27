package com.example.firstandroid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 动态注册广播接收器
 * 
 * <pre>
 * 系统广播：Intent..ACTION_BATTERY_CHANGED,接收的信息如下：
 * “present”--是否使用电池
 * “level”--电池剩余容量
 * “scale”--电池最大值，通常为100
 * “icon-small”--图标id
 * “voltage”--电池的电压（伏特）
 * “temperature”--电池温度
 * “technology”--电池类型
 * “plugged”--充电方式
 * “status”--电池状态
 * </pre>
 * 
 * @author Administrator
 *
 */
public class DynamicRegisterBroadcastReceiver extends Activity {
	private TextView battery;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dynamic_register_broadcast_receiver);
		
		battery = (TextView) findViewById(R.id.text_view_battery);
	}
	
	/**
	 * 动态注册广播接收器
	 */
	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batteryBR, intentFilter);
	}
	
	/**
	 * 取消注册广播接收器
	 */
	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(batteryBR);
	}
	
	private BroadcastReceiver batteryBR= new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if(Intent.ACTION_BATTERY_CHANGED.equals(action)){
				
				
				boolean present = intent.getBooleanExtra("present", false);
				int level = intent.getIntExtra("level", 0);
				int scale = intent.getIntExtra("scale", 0);
				
				int voltage = intent.getIntExtra("voltage", 0);
				int temperature = intent.getIntExtra("temperature", 0);
				String technology = intent.getStringExtra("technology");
				
				String status = getStatus(intent);
				String health = getHealth(intent);
				String plugged = getPlugged(intent);
				
				StringBuffer text = new StringBuffer("电池状态信息如下：\n");
				text.append("\n是否使用电池：" + present);
				text.append("\n电池状态：" + status);
				text.append("\n电池电量：" + level + "%");
				text.append("\n电池健康状态：" + health);
				text.append("\n最大值：" + scale);
				text.append("\n充电方式：" + plugged);
				text.append("\n电池电压：" + voltage);
				text.append("\n电池温度：" + temperature);
				text.append("\n电池类型：" + technology);
				
				battery.setText(text.toString());
			}
		}
		
		private String getPlugged(Intent intent){
			int plugged = intent.getIntExtra("plugged", 0);
			String value = "未知状态";
			switch (plugged) {
			case BatteryManager.BATTERY_PLUGGED_AC:
				value = "直流充电";
				break;
			case BatteryManager.BATTERY_PLUGGED_USB:
				value = "USB充电";
				break;
			case BatteryManager.BATTERY_PLUGGED_WIRELESS:
				value = "无线电充电";
				break;
			}
			
			return value;
		}
		
		private String getHealth(Intent intent){
			int health = intent.getIntExtra("health", 1);
			String value = "未知状态";
			switch (health) {
			case BatteryManager.BATTERY_HEALTH_UNKNOWN:
				value = "未知状态";
				break;
			case BatteryManager.BATTERY_HEALTH_GOOD:
				value = "状态好";
				break;
			case BatteryManager.BATTERY_HEALTH_COLD:
				value = "电池过热";
				break;
			case BatteryManager.BATTERY_HEALTH_DEAD:
				value = "电池没有电";
				break;
			case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
				value = "电池电压过高";
				break;
			case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
				value = "未知错误";
				break;
			}
			
			return value;
		}
		
		private String getStatus(Intent intent){
			int status = intent.getIntExtra("status", 0);
			String value = "未知状态";
			switch (status) {
			case BatteryManager.BATTERY_STATUS_UNKNOWN:
				value = "未知状态";
				break;
			case BatteryManager.BATTERY_STATUS_CHARGING:
				value = "充电状态";
				break;
			case BatteryManager.BATTERY_STATUS_DISCHARGING:
				value = "放电状态";
				break;
			case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
				value = "未充电";
				break;
			case BatteryManager.BATTERY_STATUS_FULL:
				value = "充满电";
				break;
			default:
				break;
			}
			
			return value;
		}
	};
}
