package de.marcusschiesser.cache;

import java.net.URL;

/**
 * this maps URLS to the required Pattern {@link DiskLruCache.LEGAL_KEY_PATTERN }
 * works only for flickr URLS (see http://www.flickr.com/services/api/misc.urls.html)
 * 
 * @author Marcus
 */
public class FlickrURLEncoder implements CacheKeyEncoder<URL> {
	@Override
	public String encode(URL url) {
		return url.toString().
				// remove protocol "http://"
				substring(7).
				replace("farm", "").
				replace(".staticflickr.com", "").
				replace('/', '_').
				replace('.', '_');	
	}
}
