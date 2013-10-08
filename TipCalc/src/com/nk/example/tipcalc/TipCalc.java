package com.nk.example.tipcalc;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalc extends Activity {
	EditText etTipAmt, etAmount, etTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		etAmount = (EditText) findViewById(R.id.etAmount);
		etTipAmt = (EditText) findViewById(R.id.etTipAmt);
		etTotal = (EditText) findViewById(R.id.etTotal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

	public void onClr(View v) {
		etAmount.getText().clear();
		etTipAmt.getText().clear();
		etTotal.getText().clear();
	}

	public void calc10Pct(View v) {
		calcTip(10);
	}

	public void calc15Pct(View v) {
		calcTip(15);
	}

	public void calc20Pct(View v) {
		calcTip(20);
	}

	private void calcTip(double tipPct) {
		
		if ( etAmount.getText().length() > 0 && Double.parseDouble(etAmount.getText().toString()) >= 0.1 ) {
			double theAmount = Double.parseDouble(etAmount.getText().toString());
			double tipAmt = theAmount * tipPct / 100;
			double total = theAmount + tipAmt;
			DecimalFormat df = new DecimalFormat("#.00");
			// Toast.makeText(this, "Amount is $" + theAmount + " Tip is $" +
			// tipAmt, Toast.LENGTH_SHORT).show();
			etAmount.setText(df.format(theAmount));
			etTipAmt.setText("$ " + df.format(tipAmt));
			etTotal.setText("$ " + df.format(total));
		} else {
			Toast.makeText(this, "Please enter an amount, atleast 10c", Toast.LENGTH_SHORT).show();
		}
	}

}
