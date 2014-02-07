package de.dennis_boldt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceUtil {

	public static URL toURL(String resource) {
		URL url = ResourceUtil.class.getResource(resource);
		//System.out.println("URL:" + url.toString());
		return url;
	}

	public static URI toURI(String resource) throws URISyntaxException {
		URI uri = toURL(resource).toURI();
		//System.out.println("URI: " + uri.toString());
		return uri;
	}

	// File-System Path!
	public static Path toPath(String resource) throws URISyntaxException {
		Path path = Paths.get(toURI(resource));
		//System.out.println("Path: " + path.toString());
		return path;
	}

	public static InputStream toInputStream(String resource) throws IOException, URISyntaxException {
		InputStream is = ClassLoader.class.getResourceAsStream(resource);
		//InputStream is = Files.newInputStream(toPath(resource));
		//System.out.println("InputStream: " + is.toString());
		return is;
	}

	public static String toString(String resource) throws IOException, URISyntaxException {
		String s = StreamUtil.toString(toInputStream(resource));
		//System.out.println("String: " + s.toString());
		return s;
	}
}
