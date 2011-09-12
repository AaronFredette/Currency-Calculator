package examples.currency;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class CurrencyConverterActivity extends Activity implements OnClickListener {
	TextView dollars;
	TextView euros;
    RadioButton dtoe;
    RadioButton etod;
	Button convert;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        dollars = (TextView)this.findViewById(R.id.dollars);
        euros = (TextView)this.findViewById(R.id.euros);
        
        dtoe = (RadioButton)this.findViewById(R.id.dtoe);
        dtoe.setChecked(true);
        etod = (RadioButton)this.findViewById(R.id.etod);
        
        convert = (Button)this.findViewById(R.id.convert);
        convert.setOnClickListener(this);
    }
    
	public void onClick(View v) {
		if (dtoe.isChecked()) {
			convertDollarsToEuros();
		}
		if (etod.isChecked()) {
			convertEurosToDollars();
		}
	}
	
	protected void convertDollarsToEuros() {
		double val = Double.parseDouble(dollars.getText().toString());
		// in a real app, we'd get this off the 'net
		if( val != 0)
		{
			euros.setText(Double.toString(val*0.67));
		}
	}
	
	protected void convertEurosToDollars() {
		
		double val = Double.parseDouble(euros.getText().toString());
		if(val !=0){
			// in a real app, we'd get this off the 'net
			dollars.setText(Double.toString(val/0.67));
		}
	}
}