
package com.emotion.database;

import java.util.ArrayList;
import java.util.List;

import com.emotion.model.Joke;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DBDataSource
{
	// Database fields
	private SQLiteDatabase		database;
	private SimpleSQLiteHelper	dbHelper;



	public DBDataSource ( Context context )
	{
		dbHelper = new SimpleSQLiteHelper ( context );
	}



	public void open ( ) throws SQLException
	{
		database = dbHelper.getWritableDatabase ( );
	}



	public void close ( )
	{
		dbHelper.close ( );
	}



	/*
	 * Joke Stuff
	 */
	public Joke createJoke ( String title, String joke )
	{
		ContentValues values = new ContentValues ( );
		values.put ( Tables.JOKE_TITLE, title );
		values.put ( Tables.JOKE_TEXT, joke );
		long insertId = database.insert ( Tables.JOKES_TABLE, null, values );
		Cursor c = database.query ( Tables.JOKES_TABLE, Tables.JOKE_COLUMNS, Tables.JOKE_ID + " = " + insertId, null, null, null, null );
		Joke j = convertCursorToJoke ( c );
		c.close ( );
		return j;
	}



	private Joke convertCursorToJoke ( Cursor c )
	{
		long jokeId = c.getLong ( 0 );
		String jokeTitle = c.getString ( 1 );
		String jokeText = c.getString ( 2 );
		boolean jokeFav = c.getInt ( 3 ) > 0;
		return new Joke ( jokeId, jokeTitle, jokeText, jokeFav );
	}



	public void delete ( Joke joke )
	{
		long id = joke.getId ( );
		database.delete ( Tables.JOKES_TABLE, Tables.JOKE_ID + " = " + id, null );
	}



	public List < Joke > getAllJokes ( )
	{
		List < Joke > jokes = new ArrayList < Joke > ( );
		Cursor cursor = database.query ( Tables.JOKES_TABLE, Tables.JOKE_COLUMNS, null, null, null, null, null );
		cursor.moveToFirst ( );
		while ( !cursor.isAfterLast ( ) )
		{
			Joke joke = convertCursorToJoke ( cursor );
			jokes.add ( joke );
			cursor.moveToNext ( );
		}
		// Make sure to close the cursor
		cursor.close ( );
		return jokes;
	}
}
