package org.cjwilson.structures.binpacking;

import java.util.List;

interface BinPacking {
	
	public List<List<Double>> pack(List<Double> items);
}