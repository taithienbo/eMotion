
package com.emotion;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class FavoriteActivity extends Activity
{
	private ListView				favoritesListView;
	private List < FavoriteListItem >	favoritesList;
	private MyListContentAdapter		adapter;


	/** Called when the activity is first created. */
	@Override
	public void onCreate ( Bundle savedInstanceState )
	{
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.favorites_layout );
		favoritesListView = (ListView) findViewById ( R.id.favorites_listview );
		adapter = new MyListContentAdapter ( this );
		favoritesListView.setAdapter ( adapter );
	}


	private final class FavoriteListItem
	{
		String	text;
	}

	public static class MyListContentAdapter extends BaseAdapter implements Filterable
	{
		private LayoutInflater	mInflater;
		private Bitmap			mIcon1;
		private Context		context;



		public MyListContentAdapter ( Context context )
		{
			// Cache the LayoutInflate to avoid asking for a
			// new one each time.
			mInflater = LayoutInflater.from ( context );
			this.context = context;
		}



		/**
		 * Make a view to hold each row.
		 * 
		 * @see android.widget.ListAdapter#getView(int,
		 *      android.view.View, android.view.ViewGroup)
		 */
		public View getView ( final int position, View convertView, ViewGroup parent )
		{
			// A ViewHolder keeps references to children
			// views to avoid
			// unneccessary calls
			// to findViewById() on each row.
			ViewHolder holder;
			// When convertView is not null, we can reuse it
			// directly, there is
			// no need
			// to reinflate it. We only inflate a new View
			// when the convertView
			// supplied
			// by ListView is null.
			if ( convertView == null )
			{
				convertView = mInflater.inflate ( R.layout.favorites_list_item_layout, null );
				// Creates a ViewHolder and store references
				// to the two children
				// views
				// we want to bind data to.
				holder = new ViewHolder ( );
				holder.textLine = (TextView) convertView.findViewById ( R.id.favorite_item_text );
				holder.iconLine = (ImageView) convertView.findViewById ( R.id.favorite_item_icon );
				convertView.setOnClickListener ( new OnClickListener ( )
				{
					private int	pos	= position;



					public void onClick ( View v )
					{
						Toast.makeText ( context, "Click-" + String.valueOf ( pos ), Toast.LENGTH_SHORT ).show ( );
					}
				} );
				convertView.setTag ( holder );
			}
			else
			{
				// Get the ViewHolder back to get fast
				// access to the TextView
				// and the ImageView.
				holder = (ViewHolder) convertView.getTag ( );
			}
			// Icons bound to the rows.
			mIcon1 = BitmapFactory.decodeResource ( context.getResources ( ), R.drawable.ic_launcher );
			// Bind the data efficiently with the holder.
			holder.iconLine.setImageBitmap ( mIcon1 );
			holder.textLine.setText ( "Position " + position + "!" );
			return convertView;
		}


		static class ViewHolder
		{
			TextView	textLine;
			ImageView	iconLine;
		}



		public Filter getFilter ( )
		{
			// TODO Auto-generated method stub
			return null;
		}



		public long getItemId ( int position )
		{
			// TODO Auto-generated method stub
			return 0;
		}



		public int getCount ( )
		{
			// TODO Auto-generated method stub
			return 200;
		}



		public Object getItem ( int position )
		{
			// TODO Auto-generated method stub
			return "pos: " + position;
		}
	}
}
