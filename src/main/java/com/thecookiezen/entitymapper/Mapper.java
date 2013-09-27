package com.thecookiezen.entitymapper;

/**
 * @author nikom
 */
public interface Mapper<T> {
	
	<D> D apply(Class<D> dstClass, T src);
	
}
