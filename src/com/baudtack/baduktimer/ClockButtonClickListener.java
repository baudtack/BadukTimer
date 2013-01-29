package com.baudtack.baduktimer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

public class ClockButtonClickListener implements OnClickListener {

	public static GameClock WhiteClock;
	public static GameClock BlackClock;
	
	public Button findOpponentButton(View v) {
		int opponentButton = 0;
	
		int vid = v.getId();
		if (vid == R.id.white_button) {
			opponentButton = R.id.black_button;
		} else {
			opponentButton = R.id.white_button;
		}
		
		Button b = null;
  		ViewGroup row = (ViewGroup) v.getParent();
		for (int itemPos = 0; itemPos < row.getChildCount(); itemPos++) {
		    View view = row.getChildAt(itemPos);
		    if (view instanceof Button && view.getId() == opponentButton) {
		         b = (Button) view; //Found it!
		         break;
		    }
		}
		return b;
	}

	
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.black_button) {
			ClockButtonClickListener.BlackClock.pause();
			ClockButtonClickListener.WhiteClock = ClockButtonClickListener.WhiteClock.run();
		} else {
			ClockButtonClickListener.WhiteClock.pause();
			ClockButtonClickListener.BlackClock = ClockButtonClickListener.BlackClock.run();		
		}

		//toggle buttons
		v.setEnabled(false);
		Button opponentButton = this.findOpponentButton(v);
		opponentButton.setEnabled(true);
	}

}
