package com.emotion;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TabWidget extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tabwidget);

	    Resources res = getResources(); 
	    TabHost tabHost = getTabHost();  
	    TabHost.TabSpec spec;  
	    Intent intent;  


	    // Events tab
	    intent = new Intent().setClass(this, EMotionActivity.class);
	    spec = tabHost.newTabSpec("events").setIndicator("Main",
	                      res.getDrawable(R.layout.ic_tab_list))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    //Favorites
	    intent = new Intent().setClass(this,EMotionActivity.class);
	    spec = tabHost.newTabSpec("favorites").setIndicator("Favorites",
	    res.getDrawable(R.layout.ic_tab_fav))
	    .setContent(intent);
	    
	    tabHost.addTab(spec);
	    
	    //addEvents
	    intent = new Intent().setClass(this,EMotionActivity.class);
	    spec = tabHost.newTabSpec("addevents").setIndicator("Create",
	                      res.getDrawable(R.layout.ic_tab_add))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    // Manage tab
	    intent = new Intent().setClass(this,EMotionActivity.class);
	    spec = tabHost.newTabSpec("Manage").setIndicator("Manage",
	                      res.getDrawable(R.layout.ic_tab_manage))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    tabHost.setCurrentTab(4);
	}
}

