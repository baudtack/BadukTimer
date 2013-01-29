package com.baudtack.baduktimer;
import android.os.CountDownTimer;

import android.widget.TextView;

public abstract class GameClock extends CountDownTimer {
	
	public enum ClockState { INACTIVE, RUNNING, PAUSED }

	protected TextView tv;
	//in seconds
	protected long timeRemaining;
	public ClockState status = ClockState.INACTIVE;
	
	public GameClock(long seconds, TextView tv) {
		super(seconds * 1000, 1000);
		this.tv = tv;
		this.timeRemaining = seconds;
    
	}

	public void pause(){
		this.status = ClockState.PAUSED;
		this.cancel();
	}
	
	public GameClock run(){
		GameClock t;
		if(this.status == ClockState.INACTIVE) {
			t = (GameClock)this.begin();
		} else {
			t = this.resume();
		}
		return t;
	}
	
	public abstract GameClock resume();

	@Override
	public void onTick(long millisUntilFinished) {
		this.timeRemaining = millisUntilFinished / 1000;
		this.tv.setText(this.formatSeconds(this.timeRemaining));
	}
	
	public String formatSeconds(long s) {
		long min = s / 60;
		long sec = s % 60;
		return min + ":" + (sec < 10 ? "0" + sec : sec);
	}
	
	// It's very annoying to have to implement this to bypass the fact that start() is final.
	public CountDownTimer begin(){
		this.status = ClockState.RUNNING;
		return super.start();
	}
	
}
