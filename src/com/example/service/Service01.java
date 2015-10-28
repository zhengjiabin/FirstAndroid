package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * <pre>
 * һ��ʲô��Service��
 * 		service��android���Ĵ����֮һ����Ҫ �����ں�̨����һЩ��ʱ���߼�������ִ��ĳЩ��Ҫ�������е�����
 * ��Ҫʱ�����ڿ����ڳ����˳�������£���service�ں�̨������������״̬��
 * 		ע�⣺��Ŀ�е�ÿһ��service��������androidManifest.xml��ע�ᡣ
 * 			ע����ʽ��<service android:name=""..></service>
 * 			�ڵ�����˵����
 * 			android:name--��������
 * 			android:label--��������֣����������ã���ôĬ����ʾ�ķ�������Ϊ����
 * 			android:icon--�����ͼ��
 * 			android:permission--�����η����Ȩ�ޣ�����ζ��ֻ���ṩ�˸�ȫѡ��Ӧ�ò��ܿ��ƻ����Ӵ˷���
 * 			android:process--��ʾ�÷����Ƿ�������������һ�����̣���������˴����ô�����ٱ��������������ַ�����ʾ��һ���̵�����
 * 			android:enabled--�����������true,��ôservice����Ĭ�ϱ�ϵͳ������������Ĭ�ϴ���Ϊfalse
 * 			android:exported--��ʾ�÷����Ƿ��ܹ�������Ӧ�ó��������ƻ����ӣ�������Ĭ�ϴ���Ϊfalse
 * 
 * ����service�ķ��ࣺ
 * 1����ִ�еط����Է�Ϊ�����ط���local service����Զ�̷���remote service��
 * 		���ط��񣺸÷����������������ϣ������̱�kill�󣬷�������ֹ
 * 		Զ�̷��񣺸÷����Ƕ����Ľ��̣���ռ��һ����Դ������ʹ��AIDL(android�ӿڶ�������)����IPC(�����ͨ��)��΢�鷳Щ
 * 
 * 2�����������ͷ��ࣺ��̨�����ǰ̨����
 * 		��̨����Ĭ�ϵķ���Ϊ��̨���񣬼�������֪ͨһ����ʾ����ִ�еķ���
 * 		ǰ̨���񣺻���֪ͨһ����ʾONGOING��Notification
 * 
 * 3����ʹ�÷�ʽ����
 * 		��������startService������Ҫ��������һ������ִ�к�̨���񣬲�����ͨ�š�ֹͣ����ʹ��stopService
 * 		�󶨷���bindService�����÷��������ķ���Ҫ����ͨ�š�ֹͣ����ʹ��unbindService
 * 		��������Ͱ󶨷���ͬʱʹ�ã�ֹͣ����Ӧͬʱʹ��stopService��unbindService
 * 
 * ����service��������
 * 1��startService��
 * 		onCreate() -> onStartCommand() -> [Service running] -> [Service stop] -> onDestroy()
 * 2��bindService��
 * 		onCreate() -> onBind() -> [Service running] -> [all client unbind] -> onUnbind() -> onDestroy()
 * 
 * �ġ�service��activity��ͨ��
 * 		startService������service��activity�Ĺ�ϵ��ʵ������ֻ��activity֪ͨ��serviceһ�¿��������ˣ����Ҫ�������й�������ôonBind()����
 * 		����service��activity���������ġ�
 * 		����������
 * 1����дonBind()
 * 2������һ����̳�Binder,���Ŀ�����
 * 3����activity����һ��serviceConnection��������,��������д��onServiceConnected()������onServiceDisconnected()�����������������ֱ����
 * 		activity��service���������ͽ��������ʱ����á�
 * 4������bindService(bindIntent,connection,BIND_AUTO_CREATE)
 * 5��unbindService(connection)
 * </pre>
 * 
 * @author Administrator
 *
 */
public class Service01 extends Service {
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(this.getClass().getName(), "onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(this.getClass().getName(), "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(this.getClass().getName(), "onDestory");
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i(this.getClass().getName(), "onBind");
		return null;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.i(this.getClass().getName(), "onUnbind");
		return super.onUnbind(intent);
	}
}
