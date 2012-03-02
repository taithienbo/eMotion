
package com.emotion.model;

public class Quote
{
	private long		id;
	private String		title;
	private String		quote;
	private boolean	favorited;



	public Quote ( long id, String title, String quote, boolean favorited )
	{
		this.id = id;
		this.title = title;
		this.quote = quote;
		this.favorited = favorited;
	}



	public boolean isFavorited ( )
	{
		return favorited;
	}



	public void setFavorited ( boolean favorited )
	{
		this.favorited = favorited;
	}



	public long getId ( )
	{
		return id;
	}



	public String getTitle ( )
	{
		return title;
	}



	public String getQuote ( )
	{
		return quote;
	}
}
