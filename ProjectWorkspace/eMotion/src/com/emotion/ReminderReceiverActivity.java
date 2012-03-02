package com.emotion;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ReminderReceiverActivity extends Activity {
	private MediaPlayer mediaPlayer;
	private PowerManager.WakeLock wl;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
        wl.acquire();

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | 
			    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | 
			    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | 
			    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
			    WindowManager.LayoutParams.FLAG_FULLSCREEN | 
			    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | 
			    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | 
			    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

		setContentView(R.layout.reminder);

		Button stopReminder = (Button) findViewById(R.id.stopAlarm);
		stopReminder.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View arg0, MotionEvent arg1) {
				finish();
				return false;
			}
		});

		playSound(this, getAlarmUri());
	}

	public void playSound(Context context, Uri alert) {
		mediaPlayer = new MediaPlayer();

		try {
			mediaPlayer.setDataSource(context, alert);
			final AudioManager audioManager = (AudioManager) context
					.getSystemService(Context.AUDIO_SERVICE);

			if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
				mediaPlayer.prepare();
				mediaPlayer.start();
			}
		} catch (IOException e) {
			System.out.println("OOPS");
		}
	}

	// Get an alarm sound. Try for an alarm. If none set, try notification,
	// Otherwise, ring tone.
	private Uri getAlarmUri() {
		Uri alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
		if (alert == null) {
			alert = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			if (alert == null) {
				alert = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
			}
		}
		return alert;
	}
	 
	protected void onStop() {
	    super.onStop();
	    wl.release();
	}
}
