package es.guido;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;

public class DragonService extends Service {
	private View view;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		view = new DragonView(this);
		
		int windowFlags = WindowManager.LayoutParams.FLAG_IGNORE_CHEEK_PRESSES 
				| WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH 
				| WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
		
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                windowFlags,
                PixelFormat.TRANSLUCENT);
        
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(view, params);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (view != null) {
			WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
			wm.removeView(view);
			view = null;
		}
	}
}
