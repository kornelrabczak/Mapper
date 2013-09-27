package com.thecookiezen.entitymapper;

/**
 * @author nikom
 */
public interface Mapper<T, K> {
	
	K apply(T src);
	
}
