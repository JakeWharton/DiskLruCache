package de.marcusschiesser.cache.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.test.AndroidTestCase;
import de.marcusschiesser.cache.BitmapValueCodec;
import de.marcusschiesser.cache.FlickrURLEncoder;
import de.marcusschiesser.cache.GenericDiskLruCache;

public class GenericDiskLruCacheTest extends AndroidTestCase {
	private static final String CACHE_NAME = "TestCache";
	private static final int DISK_CACHE_SIZE = 1024 * 1024 * 5; // 5MB
	private GenericDiskLruCache<URL, Bitmap> mDiskCache;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		final String cachePath = mContext.getCacheDir().getPath();
		final File cacheDir = new File(cachePath + File.separator
				+ CACHE_NAME);
		mDiskCache = new GenericDiskLruCache<URL,Bitmap>(cacheDir,
				DISK_CACHE_SIZE, new FlickrURLEncoder(), new BitmapValueCodec());
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		mDiskCache.delete();
	}
	
	public void testDiskCacheHit() throws Exception {
		URL url = createURL();
		Bitmap bitmap = createImage();
		mDiskCache.putValue(url, bitmap);
		Bitmap cachedBitmap = mDiskCache.getValue(url);
		// Bitmaps are compressed in the cache, so it is difficult to compare
		// for equality,
		// so just do a width and height comparison
		assertEquals(bitmap.getWidth(), cachedBitmap.getWidth());
		assertEquals(cachedBitmap.getHeight(), cachedBitmap.getHeight());
	}

	public void testDiskCacheFail() throws Exception {
		URL url = createURL();
		Bitmap cachedBitmap = mDiskCache.getValue(url);
		assertNull(cachedBitmap);
	}

	private URL createURL() throws MalformedURLException {
		URL url = new URL(
				"http://test.test/test.jpg");
		return url;
	}

	private Bitmap createImage() {
		Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		return bitmap;
	}
}
