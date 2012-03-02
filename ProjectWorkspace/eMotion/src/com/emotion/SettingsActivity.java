package com.emotion;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;

public class SettingsActivity extends Activity {
	
	public final static String[] JOKE_OPTIONS = new String[] { 
		"Show Jokes", 
		"Show Pictures", 
		"Show Motivational Passage" 
	};
	
	public final static String PREFERENCE = "user_preference";
	public final static String INTERVAL_MIN = "hour";
	public final static String INTERVAL_HOUR = "minute";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.settings_page_layout);
		
		// Setting up a list of jokes
		final ListView list = (ListView) this.findViewById(R.id.jokeList);
		list.setAdapter(new ArrayAdapter<String>(this, R.layout.settings_checked_textview, JOKE_OPTIONS));
		
		list.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				list.setSelection(position);
			}
		});
	
		// Set up the interval picker
		final TimePicker picker = (TimePicker) this.findViewById(R.id.intervalPicker);
		picker.setIs24HourView(true);
		SharedPreferences userPreferences = SettingsActivity.this.getSharedPreferences(
				SettingsActivity.PREFERENCE, Activity.MODE_PRIVATE);

		picker.setCurrentHour(userPreferences.getInt(INTERVAL_HOUR, 0));
		picker.setCurrentMinute(userPreferences.getInt(INTERVAL_MIN, 5));
		
		// Set action listener for save settings button
		Button saveButton = (Button) this.findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new OnClickListener()
		{

			public void onClick(View arg0) {
				SharedPreferences userPreferences = SettingsActivity.this.getSharedPreferences(
						SettingsActivity.PREFERENCE, Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = userPreferences.edit();
				Log.d("Interval value", String.valueOf(picker.getCurrentMinute() + picker.getCurrentHour() * 60));
				editor.putInt(INTERVAL_MIN, picker.getCurrentMinute());
				editor.putInt(INTERVAL_HOUR, picker.getCurrentHour());
				editor.commit();
			}
			
		});
	}

}
