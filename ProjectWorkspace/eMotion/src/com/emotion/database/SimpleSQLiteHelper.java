
package com.emotion.database;

import com.emotion.ContentManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class SimpleSQLiteHelper extends SQLiteOpenHelper
{
	private Context context;

	public SimpleSQLiteHelper ( Context context )
	{
		super ( context, Tables.DATABASE_NAME, null, Tables.DATABASE_VERSION );
		this.context = context;
	}



	@Override
	public void onCreate ( SQLiteDatabase db )
	{
		/*
		 * Create the tables.
		 */
		String tableCreationStatements = ContentManager.loadResFile ( context, "createtables.sql" );
		db.execSQL ( tableCreationStatements );
	}

	@Override
	public void onUpgrade ( SQLiteDatabase db, int oldVersion, int newVersion )
	{
		// TODO Auto-generated method stub
	}
}
