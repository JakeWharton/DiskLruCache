package de.marcusschiesser.cache;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import android.util.Log;

import com.jakewharton.DiskLruCache;

/**
 * Uses the Jake Wharton's DiskLruCache implementation to provide a generic disk
 * cache with a key class K and a value class V. For the underlying cache
 * implementation the keys must be encoded to strings with a format given by
 * {@link DiskLruCache.LEGAL_KEY_PATTERN }. A implementation of
 * {@link CacheKeyEncoder} must be provided for that purpose. Values store by
 * the cache must be decoded and encoded by implementations of
 * {@link CacheValueCodec}.
 * 
 * Code is based on the following discussion on stackoverflow.com:
 * 
 * http://stackoverflow.com/questions/10185898/using-disklrucache-in-android-4-0
 * -does-not-provide-for-opencache-method
 * 
 * @author Marcus
 * 
 */
public class GenericDiskLruCache<K, V> {
	private static final int APP_VERSION = 1;
	private static final int VALUE_COUNT = 1;
	private static final int IO_BUFFER_SIZE = 8 * 1024;

	private DiskLruCache mDiskCache;
	private CacheKeyEncoder<K> mCacheKeyEncoder;
	private CacheValueCodec<V> mCacheValueCodec;

	public GenericDiskLruCache(File cacheDir, int diskCacheSize,
			CacheKeyEncoder<K> keyEncoder, CacheValueCodec<V> valueCodec)
			throws IOException {
		mDiskCache = DiskLruCache.open(cacheDir, APP_VERSION, VALUE_COUNT,
				diskCacheSize);
		mCacheKeyEncoder = keyEncoder;
		mCacheValueCodec = valueCodec;
	}

	/**
	 * Stores the provided value using the provided key
	 * 
	 * @param key
	 * @param value
	 * @throws IOException
	 */
	public void putValue(K key, V value) throws IOException {
		DiskLruCache.Editor editor = null;
		try {
			editor = mDiskCache.edit(mCacheKeyEncoder.encode(key));
			if (editor == null) {
				return;
			}
			final OutputStream bos = new BufferedOutputStream(
					editor.newOutputStream(0), IO_BUFFER_SIZE);
			try {
				if (mCacheValueCodec.encode(value, bos)) {
					mDiskCache.flush();
					editor.commit();
					Log.d(GenericDiskLruCache.class.getSimpleName(),
							"value put on disk cache " + key);
				} else {
					editor.abort();
					Log.d(GenericDiskLruCache.class.getSimpleName(),
							"ERROR on: value put on disk cache " + key);
				}
			} finally {
				bos.close();
			}
		} catch (IOException e) {
			if (editor != null) {
				editor.abort();
			}
			throw e;
		}
	}

	/**
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public V getValue(K key) throws IOException {
		V bitmap = null;
		DiskLruCache.Snapshot snapshot = null;
		try {
			snapshot = mDiskCache.get(mCacheKeyEncoder.encode(key));
			if (snapshot == null) {
				return null;
			}
			final BufferedInputStream in = new BufferedInputStream(
					snapshot.getInputStream(0), IO_BUFFER_SIZE);
			bitmap = mCacheValueCodec.decode(in);
		} finally {
			if (snapshot != null) {
				snapshot.close();
			}
		}
		Log.d(GenericDiskLruCache.class.getSimpleName(), bitmap == null ? ""
				: "value read from disk " + key);
		return bitmap;

	}

	public void delete() throws IOException {
		mDiskCache.delete();
	}

}
