package de.marcusschiesser.cache;

/**
 * Very simple key encoder that just returns the identity of the key
 * 
 * @author Marcus
 */
public class DefaultKeyEncoder implements CacheKeyEncoder<String> {

	@Override
	public String encode(String key) {
		return key;
	}

}
