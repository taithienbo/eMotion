package com.emotion;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class FileMap {

	private static final String MAP_FILE_NAME = "map";

	private static File mapFile;

	private static HashMap<String, String> map;

	@SuppressWarnings("unchecked")
	public static void initialize(String directory) {
		try {
			File dir = new File(directory);
			mapFile = new File(dir, MAP_FILE_NAME);
			if (!(mapFile.exists() && mapFile.isFile()))
				mapFile.createNewFile();
			else
				readMap();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			map = map == null ? map : new HashMap<String, String>();
		}
	}

	public static String put(String key, String value) {
		String old = map.put(key, value);
		writeMap();
		return old;
	}

	public static String get(String key, String forDefault) {
		readMap();
		String toReturn = map.get(key);
		return toReturn == null ? forDefault : toReturn;
	}

	private static void writeMap() {
		try {
			OutputStream file = new FileOutputStream(mapFile);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);

			output.writeObject(map);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private static void readMap() {
		try {
			InputStream file = new FileInputStream(mapFile);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			map = (HashMap<String, String>) input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			map = map == null ? new HashMap<String, String>() : map;
		}
	}
}
