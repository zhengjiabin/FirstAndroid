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
 * ��̬ע��㲥������
 * 
 * <pre>
 * ϵͳ�㲥��Intent..ACTION_BATTERY_CHANGED,���յ���Ϣ���£�
 * ��present��--�Ƿ�ʹ�õ��
 * ��level��--���ʣ������
 * ��scale��--������ֵ��ͨ��Ϊ100
 * ��icon-small��--ͼ��id
 * ��voltage��--��صĵ�ѹ�����أ�
 * ��temperature��--����¶�
 * ��technology��--�������
 * ��plugged��--��緽ʽ
 * ��status��--���״̬
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
	 * ��̬ע��㲥������
	 */
	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batteryBR, intentFilter);
	}
	
	/**
	 * ȡ��ע��㲥������
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
				
				StringBuffer text = new StringBuffer("���״̬��Ϣ���£�\n");
				text.append("\n�Ƿ�ʹ�õ�أ�" + present);
				text.append("\n���״̬��" + status);
				text.append("\n��ص�����" + level + "%");
				text.append("\n��ؽ���״̬��" + health);
				text.append("\n���ֵ��" + scale);
				text.append("\n��緽ʽ��" + plugged);
				text.append("\n��ص�ѹ��" + voltage);
				text.append("\n����¶ȣ�" + temperature);
				text.append("\n������ͣ�" + technology);
				
				battery.setText(text.toString());
			}
		}
		
		private String getPlugged(Intent intent){
			int plugged = intent.getIntExtra("plugged", 0);
			String value = "δ֪״̬";
			switch (plugged) {
			case BatteryManager.BATTERY_PLUGGED_AC:
				value = "ֱ�����";
				break;
			case BatteryManager.BATTERY_PLUGGED_USB:
				value = "USB���";
				break;
			case BatteryManager.BATTERY_PLUGGED_WIRELESS:
				value = "���ߵ���";
				break;
			}
			
			return value;
		}
		
		private String getHealth(Intent intent){
			int health = intent.getIntExtra("health", 1);
			String value = "δ֪״̬";
			switch (health) {
			case BatteryManager.BATTERY_HEALTH_UNKNOWN:
				value = "δ֪״̬";
				break;
			case BatteryManager.BATTERY_HEALTH_GOOD:
				value = "״̬��";
				break;
			case BatteryManager.BATTERY_HEALTH_COLD:
				value = "��ع���";
				break;
			case BatteryManager.BATTERY_HEALTH_DEAD:
				value = "���û�е�";
				break;
			case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
				value = "��ص�ѹ����";
				break;
			case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
				value = "δ֪����";
				break;
			}
			
			return value;
		}
		
		private String getStatus(Intent intent){
			int status = intent.getIntExtra("status", 0);
			String value = "δ֪״̬";
			switch (status) {
			case BatteryManager.BATTERY_STATUS_UNKNOWN:
				value = "δ֪״̬";
				break;
			case BatteryManager.BATTERY_STATUS_CHARGING:
				value = "���״̬";
				break;
			case BatteryManager.BATTERY_STATUS_DISCHARGING:
				value = "�ŵ�״̬";
				break;
			case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
				value = "δ���";
				break;
			case BatteryManager.BATTERY_STATUS_FULL:
				value = "������";
				break;
			default:
				break;
			}
			
			return value;
		}
	};
}
