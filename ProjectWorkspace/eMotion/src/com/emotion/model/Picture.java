
package com.emotion.model;

import android.graphics.Bitmap;


public class Picture
{
	private long		id;
	private String		title;
	private Bitmap		pic;
	private boolean	favorited;



	public Picture ( long id, String title, Bitmap pic, boolean favorited )
	{
		this.id = id;
		this.title = title;
		this.pic = pic;
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



	public Bitmap getPic ( )
	{
		return pic;
	}
}
