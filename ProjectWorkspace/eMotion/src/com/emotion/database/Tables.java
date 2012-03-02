
package com.emotion.database;

public class Tables
{
	public static final String	SPACE			= " ";
	/*
	 * Database definition.
	 */
	public static final String	DATABASE_NAME		= "eMotionDatabase";
	public static final int		DATABASE_VERSION	= 1;
	public static final String	FAVORITED			= "favorited";
	/*
	 * Pictures table definition.
	 */
	public static final String	PICTURES_TABLE		= "Pictures";
	public static final String	PIC_ID			= "id";
	public static final String	PIC_TITLE			= "title";
	public static final String	PIC_FILE			= "pic";
	public static final String []	PIC_COLUMNS		= new String [ ] { PIC_ID, PIC_TITLE, PIC_FILE, FAVORITED };
	/*
	 * Jokes table definition.
	 */
	public static final String	JOKES_TABLE		= "Jokes";
	public static final String	JOKE_ID			= "id";
	public static final String	JOKE_TITLE		= "title";
	public static final String	JOKE_TEXT			= "joke";
	public static final String []	JOKE_COLUMNS		= new String [ ] { JOKE_ID, JOKE_TITLE, JOKE_TEXT, FAVORITED };
	/*
	 * Quotes table definition.
	 */
	public static final String	QUOTES_TABLE		= "Quotes";
	public static final String	QUOTE_ID			= "id";
	public static final String	QUOTE_AUTHOR		= "title";
	public static final String	QUOTE_TEXT		= "quote";
	public static final String []	QUOTE_COLUMNS		= new String [ ] { JOKE_ID, QUOTE_AUTHOR, QUOTE_TEXT, FAVORITED };
}
