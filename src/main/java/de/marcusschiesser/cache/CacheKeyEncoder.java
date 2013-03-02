package de.marcusschiesser.cache;

public interface CacheKeyEncoder<T> {
	public abstract String encode(T key);
}
