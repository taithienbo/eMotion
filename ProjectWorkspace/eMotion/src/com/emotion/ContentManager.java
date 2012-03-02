
package com.emotion;

import java.io.BufferedInputStream;
import java.io.FileReader;
import java.util.Scanner;

import android.content.Context;


public class ContentManager
{
	public static String loadResFile ( Context context, String filename )
	{
		try
		{
			return new Scanner ( context.getResources ( ).getAssets ( ).open ( filename ) ).useDelimiter ( "\\A" ).next ( );
		}
		catch ( Exception e )
		{
			e.printStackTrace ( );
			return "";
		}
	}
}
