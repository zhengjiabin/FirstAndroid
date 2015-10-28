package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * <pre>
 * 一、什么是Service？
 * 		service是android的四大组件之一，主要 用于在后台处理一些耗时的逻辑，或者执行某些需要长期运行的任务。
 * 必要时，生在可以在程序退出的情况下，让service在后台继续保持运行状态。
 * 		注意：项目中的每一个service都必须在androidManifest.xml中注册。
 * 			注册形式：<service android:name=""..></service>
 * 			节点属性说明：
 * 			android:name--服务类名
 * 			android:label--服务的名字，如果此项不设置，那么默认显示的服务名则为类名
 * 			android:icon--服务的图标
 * 			android:permission--申明次服务的权限，这意味着只有提供了该全选的应用才能控制或链接此服务
 * 			android:process--表示该服务是否运行在另外有一个进程，如果设置了此项，那么将会再报名后面加上这段字符串表示另一进程的名字
 * 			android:enabled--如果此项设置true,那么service将会默认被系统启动，不设置默认此项为false
 * 			android:exported--表示该服务是否能够被其他应用程序所控制或连接，不设置默认此项为false
 * 
 * 二、service的分类：
 * 1、按执行地方可以分为：本地服务（local service）和远程服务（remote service）
 * 		本地服务：该服务依附在主进程上，主进程被kill后，服务便会终止
 * 		远程服务：该服务是独立的进程，会占用一定资源，并且使用AIDL(android接口定义语言)进行IPC(跨进程通信)稍微麻烦些
 * 
 * 2、按运行类型分类：后台服务和前台服务
 * 		后台服务：默认的服务即为后台服务，即不会再通知一栏显示正在执行的服务
 * 		前台服务：会在通知一栏显示ONGOING的Notification
 * 
 * 3、按使用方式分类
 * 		启动服务（startService）：主要用于启动一个服务执行后台任务，不进行通信。停止服务使用stopService
 * 		绑定服务（bindService）：该方法启动的服务要进行通信。停止服务使用unbindService
 * 		启动服务和绑定服务同时使用：停止服务应同时使用stopService与unbindService
 * 
 * 三、service生命周期
 * 1、startService：
 * 		onCreate() -> onStartCommand() -> [Service running] -> [Service stop] -> onDestroy()
 * 2、bindService：
 * 		onCreate() -> onBind() -> [Service running] -> [all client unbind] -> onUnbind() -> onDestroy()
 * 
 * 四、service和activity的通信
 * 		startService开启的service和activity的关系其实并不大，只是activity通知了service一下可以启动了，如果要让它们有关联，那么onBind()就是
 * 		用于service和activity建立关联的。
 * 		具体做法：
 * 1、重写onBind()
 * 2、创建一个类继承Binder,添加目标代码
 * 3、在activity创建一个serviceConnection的匿名类,在里面重写了onServiceConnected()方法和onServiceDisconnected()方法，这两个方法分别会在
 * 		activity与service建立关联和解除关联的时候调用。
 * 4、调用bindService(bindIntent,connection,BIND_AUTO_CREATE)
 * 5、unbindService(connection)
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
