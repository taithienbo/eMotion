package com.emotion;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class ReminderMainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		// Create an offset from the current time in which the reminder will go off.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 5);
		
		// Create a new PendingIntent and add it to the AlarmManager
		Intent intent = new Intent(this, ReminderReceiverActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		AlarmManager manager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
		manager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
	}

}
