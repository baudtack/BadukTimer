package com.baudtack.baduktimer;

import android.widget.TextView;

public class AbsoluteGameClock extends GameClock {

	public AbsoluteGameClock(long seconds, TextView tv) {
		super(seconds, tv);
	}

	@Override
	public void onFinish() {
		this.tv.setText("all done!");
	}
	
	@Override
	public AbsoluteGameClock resume() {
		AbsoluteGameClock t = new AbsoluteGameClock(this.timeRemaining, this.tv);
		t.begin();
		return t;
	}

	@Override
	public void onTick(long millisUntilFinished) {
		super.onTick(millisUntilFinished);
	}

}
