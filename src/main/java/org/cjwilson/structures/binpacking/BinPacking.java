package org.cjwilson.structures.binpacking;

import java.util.List;

public interface BinPacking {
	
	public List<List<Double>> pack(List<Double> items);
}