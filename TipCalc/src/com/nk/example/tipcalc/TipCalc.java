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
	
	public void onClr (View v) {
		etAmount.setText("");
		etTipAmt.setText("");
		etTotal.setText("");
	}

	public void calc10Pct(View v) {
		if  (etAmount.getText().toString().trim().length() != 0) {
			calcTip(10);
		} else {
			Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
		}
			
	}

	public void calc15Pct(View v) {
		calcTip(15);
	}

	public void calc20Pct(View v) {
		calcTip(20);
	}

	private void calcTip(double tipPct) {
		double theAmount = Double.parseDouble(etAmount.getText().toString());
		double tipAmt = theAmount * tipPct / 100;
		double total = theAmount + tipAmt;
		DecimalFormat df = new DecimalFormat("#.00");
		// Toast.makeText(this, "Amount is $" + theAmount + " Tip is $" +
		// tipAmt, Toast.LENGTH_SHORT).show();
		etAmount.setText(df.format(theAmount));
		etTipAmt.setText("$ " + df.format(tipAmt));
		etTotal.setText("$ " + df.format(total));
	}

}
