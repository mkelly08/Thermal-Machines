package uia.GIDA.thermalmachines;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivityOtto extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_otto);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_otto, menu);
		return true;
	}

}