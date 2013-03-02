package de.marcusschiesser.cache.test;

import java.net.MalformedURLException;
import java.net.URL;

import de.marcusschiesser.cache.FlickrURLEncoder;
import junit.framework.TestCase;

public class FlickrURLEncoderTest extends TestCase {

	public void testEncode() throws MalformedURLException {
		FlickrURLEncoder encoder = new FlickrURLEncoder();
		String encoded = encoder.encode(new URL("http://farm1.staticflickr.com/2/1418878_1e92283336_m.jpg"));
		assertEquals("1_2_1418878_1e92283336_m_jpg", encoded);
	}

}
