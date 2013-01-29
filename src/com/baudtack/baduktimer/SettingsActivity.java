package com.baudtack.baduktimer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.view.View;

public class SettingsActivity extends Activity {

	private NumberPicker minute;
	private NumberPicker second;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_layout);
        this.second = (NumberPicker)this.findViewById(R.id.second);
        
        this.second.setMinValue(0);
        this.second.setMaxValue(59);
        
        this.minute = (NumberPicker)this.findViewById(R.id.minute);
        this.minute.setMinValue(0);
        this.minute.setMaxValue(90);
        
        Button start = (Button)this.findViewById(R.id.start_button);
        
        start.setOnClickListener(new Button.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent i = new Intent(getApplicationContext(), ClocksActivity.class);
        		int seconds = minute.getValue() * 60 + second.getValue(); 
        		
        		i.putExtra("seconds", seconds);
        		startActivity(i);
        	}
        });
        
    }

}
