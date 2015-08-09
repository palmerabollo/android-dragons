package es.guido;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DragonActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// start service and commit suicide
		Intent serviceIntent = new Intent(this, DragonService.class);
		this.startService(serviceIntent);
		finish();
	}
}