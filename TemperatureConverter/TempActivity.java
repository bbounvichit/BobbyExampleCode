package simple.temperatureconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.support.v4.app.NavUtils;

public class TempActivity extends Activity {

	private EditText myEditText;
	private RadioButton rbutton1;
	private RadioButton rbutton2;
	private Button button1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        myEditText = (EditText) findViewById(R.id.tempEditText);
        button1 = (Button) findViewById(R.id.button1);
	    myEditText.setOnKeyListener(new OnKeyListener() {
	    	public boolean onKey(View v, int keyCode, KeyEvent event) {
	    		if (event.getAction() == KeyEvent.ACTION_DOWN)
	    		if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
				    	onClickEvent(button1);
				    	return true;
		    		}
		    	return false;
	    		}
	    	});
    }
        
        
    public void textClick(View textview){
    	myEditText.setText("");
    }
    
    public void onClickEvent(View thisview){
    	
    	if ((myEditText.getText().equals("Enter temperature (default: 0)")) || (myEditText.getText().length() == 0)){
    		myEditText.setText("0");
    	}
    	rbutton1 = (RadioButton) findViewById(R.id.radioButton1);
    	rbutton2 = (RadioButton) findViewById(R.id.radioButton2);
    	button1 = (Button) findViewById(R.id.button1);
    	
    	switch(thisview.getId()){
    	
    		case (R.id.button1): {
    			if(rbutton1.isChecked()){
    				float Ftemp = Float.parseFloat(myEditText.getText().toString());
    				Ftemp = convertFahrenheitToCelsius(Ftemp);
    				myEditText.setText(String.valueOf(Ftemp));
    				rbutton1.setChecked(false);
    				rbutton2.setChecked(true);
    			}
    			else{
    				float Ctemp = Float.parseFloat(myEditText.getText().toString());
    				Ctemp = convertCelsiusToFahrenheit(Ctemp);
    				myEditText.setText(String.valueOf(Ctemp));
    				rbutton1.setChecked(true);
    				rbutton2.setChecked(false);
    			}
    			break;
    		}
    		default: myEditText.setText("0");break;
    	
    	}
    }
    
    
    // Converts to celsius
    private float convertFahrenheitToCelsius(float fahrenheit) {
      return ((fahrenheit - 32) * 5 / 9);
    }

    // Converts to fahrenheit
    private float convertCelsiusToFahrenheit(float celsius) {
      return ((celsius * 9) / 5) + 32;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_temp, menu);
        return true;
    }
}
