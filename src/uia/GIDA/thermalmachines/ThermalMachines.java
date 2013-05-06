package uia.GIDA.thermalmachines;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;

public class ThermalMachines extends Activity implements Runnable{

		public ProgressDialog myDialog;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_thermal_machines);
			
			// SE manda a llamar la funcion que llama el nuevo activity MainMenu
	        new Handler().postDelayed(this, 1000);// 3 Seconds
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.thermal_machines, menu);
			return true;
		}

		@Override
	public void run() {
		myDialog = ProgressDialog.show(ThermalMachines.this,"", "Loading", true);
	     //Se manda a llamar la nueva actividad
		Intent intent=new Intent(ThermalMachines.this,MainActivityOtto.class);
		ThermalMachines.this.startActivity(intent);
		myDialog.dismiss();
		// Se cierra esta actividad actividad
		ThermalMachines.this.finish(); 
		
	}

}

