package com.thecookiezen.entitymapper;

/**
 * @author nikom
 */
public interface Mapper<S, T> {
	
	T apply(S source);
	
}
