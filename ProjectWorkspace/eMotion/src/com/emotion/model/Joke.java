
package com.emotion.model;

public class Joke
{
	private long		id;
	private String		title;
	private String		joke;
	private boolean	favorite;



	public Joke ( long id, String title, String joke, boolean favorite )
	{
		this.id = id;
		this.title = title;
		this.joke = joke;
		this.favorite = favorite;
	}



	public boolean isFavorite ( )
	{
		return favorite;
	}



	public void setFavorite ( boolean favorite )
	{
		this.favorite = favorite;
	}



	public long getId ( )
	{
		return id;
	}



	public String getTitle ( )
	{
		return title;
	}



	public String getJoke ( )
	{
		return joke;
	}
}
