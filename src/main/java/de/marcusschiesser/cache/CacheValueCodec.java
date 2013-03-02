package de.marcusschiesser.cache;

import java.io.InputStream;
import java.io.OutputStream;

public interface CacheValueCodec<V> {
	public abstract boolean encode(V value, OutputStream os);
	public abstract V decode(InputStream is);
}
