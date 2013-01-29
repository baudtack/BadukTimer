package com.baudtack.baduktimer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

public class ClocksActivity extends Activity {
	
	private Button wClockButton;
	private Button bClockButton;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_clocks);
        this.wClockButton = (Button)this.findViewById(R.id.white_button);
        this.bClockButton = (Button)this.findViewById(R.id.black_button);

        ClockButtonClickListener.BlackClock = new AbsoluteGameClock(100000, (TextView)this.findViewById(R.id.black_clock));
        ClockButtonClickListener.WhiteClock = new AbsoluteGameClock(100000, (TextView)this.findViewById(R.id.white_clock));
        
        this.wClockButton.setOnClickListener(new ClockButtonClickListener());
        this.bClockButton.setOnClickListener(new ClockButtonClickListener());
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
