package com.emotion;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;


public class StartTabWidget extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		// Favorites tab
				intent = new Intent().setClass(this, FavoriteActivity.class);
				spec = tabHost
						.newTabSpec("favorites")
						.setIndicator("Favorites",
								res.getDrawable(R.layout.ic_tab_fav))
						.setContent(intent);
				tabHost.addTab(spec);
				
		// History tab
		intent = new Intent().setClass(this, EMotionActivity.class);
		spec = tabHost
				.newTabSpec("history")
				.setIndicator("History",
						res.getDrawable(R.layout.ic_tab_hist))
				.setContent(intent);
		tabHost.addTab(spec);

		

		tabHost.setCurrentTab(0);
	}
}
