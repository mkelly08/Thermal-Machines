package uia.GIDA.thermalmachines;



import uia.GIDA.thermalmachines.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class ProcesActivity extends Activity {

	private OttoModel otto;
	private TextView temp;
	private TextView pres;
	private TextView vol;
	private TextView heat;
	private TextView title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proces);
		Intent i=getIntent();
		this.otto=(OttoModel)i.getSerializableExtra("otto");
		//Log.e("ProcOtto1",""+this.otto.toString());
		//Log.e("wtf",""+i.getIntExtra("id",0));
		this.title=(TextView)findViewById(id.TextResults);
		this.temp=(TextView)findViewById(id.ResTempText);
		this.pres=(TextView)findViewById(id.ResTempPres);
		this.vol=(TextView)findViewById(id.ResTempVol);
		this.heat=(TextView)findViewById(id.ResTempHeat);
		switch(i.getIntExtra("id", 0)){
			case R.id.AdmitionButton:
				admitionShow();
				break;
			case R.id.CompressionButton:
				compressionShow();
				break;
			case R.id.Explotion:
				explotionShow();
				break;
			case R.id.Expantion:
				expantionShow();
				break;
			case R.id.Exaustion:
				exaustionShow();
				break;
			default:
				Log.e("WTF","Dont know witch button was press");
				break;
		}
		this.temp.setText(""+this.otto.getTemp());
		this.pres.setText(""+this.otto.getPres());
		this.vol.setText(""+this.otto.getVol());
		this.heat.setText(""+this.otto.getHeat());
		
	}
	
	private void admitionShow(){
		this.title.setText(R.string.titleAdmition);
		this.otto.calcAdmition();
	}
	
	private void compressionShow(){
		this.title.setText(R.string.titleCompression);
		this.otto.calcCompression();
	}
	private void explotionShow(){
		this.title.setText(R.string.titleExplotion);
		this.otto.calcExplotion();
	}
	private void expantionShow(){
		this.title.setText(R.string.titleExpantion);
		this.otto.calcExpantion();
	}
	private void exaustionShow(){
		this.title.setText(R.string.titleExaustion);
		this.otto.calcExaustion();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.proces, menu);
		return true;
	}

}
