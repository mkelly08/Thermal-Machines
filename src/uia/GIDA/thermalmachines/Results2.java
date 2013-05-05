package uia.GIDA.thermalmachines;

import uia.GIDA.thermalmachines.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Results2 extends Activity {

	private Button admitionButton;
	private Button compressionButton;
	private Button explotionButton;
	private Button expantionButton;
	private Button exaustionButton;
	private Button workButton;
	private OttoModel otto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results2);
		Intent i = getIntent();
		this.otto =(OttoModel)i.getSerializableExtra("otto");
		ResultsListener rl = new ResultsListener(this.otto);
		
		this.admitionButton=(Button)findViewById(id.AdmitionButton);
		this.compressionButton=(Button)findViewById(id.CompressionButton);
		this.explotionButton=(Button)findViewById(id.Explotion);
		this.expantionButton=(Button)findViewById(id.Expantion);
		this.exaustionButton=(Button)findViewById(id.Exaustion);
		this.workButton=(Button)findViewById(id.Work);
		
		this.admitionButton.setOnClickListener(rl);
		this.compressionButton.setOnClickListener(rl);
		this.explotionButton.setOnClickListener(rl);
		this.expantionButton.setOnClickListener(rl);
		this.exaustionButton.setOnClickListener(rl);
		this.workButton.setOnClickListener(rl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results2, menu);
		return true;
	}
	
	private class ResultsListener implements OnClickListener{
		private OttoModel otto;
		
		public ResultsListener(OttoModel otto){
			this.otto=otto;
		}
		@Override
		public void onClick(View v) {
			if(v.getId()==R.id.Work){
				Intent work = new Intent(Results2.this,WorkActivity.class);
				work.putExtra("otto",this.otto);
				Results2.this.startActivity(work);
			}else{
				Intent proces = new Intent(Results2.this,ProcesActivity.class);
				proces.putExtra("otto",this.otto);
				proces.putExtra("id", v.getId());
				Results2.this.startActivity(proces);
			}
			
		}
		
	}

}
