package de.marcusschiesser.cache;

import java.io.InputStream;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;

/**
 * Implementation of {@link CacheValueCodec} that encodes and
 * decodes instances of Bitmap in the JPEG format
 * 
 * @author Marcus
 */
public class BitmapValueCodec implements CacheValueCodec<Bitmap> {
	private final static CompressFormat COMPRESS_FORMAT = CompressFormat.JPEG;
	private final static int COMPRESS_QUALITY = 95;

	@Override
	public boolean encode(Bitmap value, OutputStream os) {
		return value.compress(COMPRESS_FORMAT, COMPRESS_QUALITY, os);
	}

	@Override
	public Bitmap decode(InputStream is) {
		return BitmapFactory.decodeStream(is);
	}

}
