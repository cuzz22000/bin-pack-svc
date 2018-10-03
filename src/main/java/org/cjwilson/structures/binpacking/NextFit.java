package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextFit implements BinPacking {
 

	@Override
	public List<List<Double>> pack(List<Double> items) {
		List<List<Double>> result = new ArrayList<>();
		double curr = 0;
		List<Double> bin = new ArrayList<>();
		result.add(bin);
		for(Double item : items) {
			if(item + curr <= 1) {
				bin.add(item);
			}else {
				curr = 0;
				bin = new ArrayList<>();
				result.add(bin);
				bin.add(item);
			}
			curr += item;
		}
		return result;
	}
}
