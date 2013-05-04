package uia.GIDA.thermalmachines;

import uia.GIDA.thermalmachines.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivityOtto extends Activity {

	private Button buttonCaculate;
	private Button buttonAbout;
	private EditText boreText;
	private EditText strokeText;
	private EditText rc;
	private EditText n;
	private EditText pa;
	private EditText ta;
	
	// Hay que poner estos en el modelo
	// private boolean bore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_otto);
				
		this.boreText=(EditText)findViewById(id.bore);
		this.strokeText=(EditText)findViewById(id.stroke);
		this.rc=(EditText)findViewById(id.rc);
		this.n=(EditText)findViewById(id.n);
		this.pa=(EditText)findViewById(id.pa);
		this.ta=(EditText)findViewById(id.ta);

		
		this.buttonAbout=(Button)findViewById(id.AboutButton);
		this.buttonAbout.setOnClickListener(new AboutListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_otto, menu);
		return true;
	}
	

	
	private class AboutListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Intent about =new Intent(MainActivityOtto.this,AboutActivity.class);
			MainActivityOtto.this.startActivity(about);
			// TODO Auto-generated method stub	
		}
		
	}

}
