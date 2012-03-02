package com.emotion;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FavoriteActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("This is the favorite tab");
		setContentView(textview);
	//	setContentView(R.layout.main);
		
		// Set a custom list view instead of using the default listView
		setContentView(R.layout.favorite_page_list_layout);
		
		// We will replace this with the data from the database 
		List<String> test_data = new ArrayList<String>();
		test_data.add("A funny joke");
		test_data.add("Another funny joke");
		test_data.add("Isn't it funny");
		
		FavoriteListAdapter<String> fla = new FavoriteListAdapter<String>(this, R.layout.favorite_page_row_layout,
				R.id.textView_favorite_item_title, test_data);
		
		setListAdapter(fla);
	}
	
	


	private class FavoriteListAdapter<T> extends ArrayAdapter<T>{
		
		
		
		public FavoriteListAdapter(Context context, int resource,
				int textViewResourceId, List<T> objects) {
			
		super(context, resource, textViewResourceId, objects);
	
		this.context = context;
		}
		
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			
			View v = convertView;
			if(v == null){
				LayoutInflater inflater = LayoutInflater.from(context);
				inflater.inflate(R.layout.favorite_page_row_layout, null);
			}
			
		
			return v;
			
		}
		
	/**	
		@Override
		public View onCreateView(View parent, String name, Context context,{
			
			return null;
		}
		
		**/
		private Context context;
	

	}
}