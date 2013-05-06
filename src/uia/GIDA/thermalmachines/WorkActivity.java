package uia.GIDA.thermalmachines;

import uia.GIDA.thermalmachines.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class WorkActivity extends Activity {
	
	private TextView qUtil;
	private TextView qEnt;
	private TextView qOut;
	private TextView eff;
	private TextView power;
	private OttoModel otto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_work);
		Intent i=getIntent();
		this.otto=(OttoModel)i.getSerializableExtra("otto");
		
		this.qUtil=(TextView)findViewById(id.ResTempQutil);
		this.qEnt=(TextView)findViewById(id.ResTempQent);
		this.qOut=(TextView)findViewById(id.ResTempQout);
		this.eff=(TextView)findViewById(id.ResTempN);
		this.power=(TextView)findViewById(id.ResTempPower);
		
		this.otto.calcExpantion();
		this.qEnt.setText(""+this.otto.getTotalHeat());
		this.otto.calcExaustion();
		this.qUtil.setText(""+this.otto.getTotalHeat());
		this.qOut.setText(""+this.otto.getHeat());
		this.eff.setText(""+this.otto.getEff());
		this.power.setText(""+this.otto.getPower());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.work, menu);
		return true;
	}

}
