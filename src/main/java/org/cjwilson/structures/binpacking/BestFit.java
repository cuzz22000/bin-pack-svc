package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestFit implements BinPacking {

	
	@Override
	public List<List<Double>> pack(List<Double> items) {
		List<List<Double>> result = new ArrayList<>();
		List<Double> remaining = new LinkedList<>();

		for (Double item : items) {

			double min = 1;
			int bestIndex = 0;
			for (int i = 0; i < remaining.size(); i++) {
				if (item <= remaining.get(i) && remaining.get(i) - item < min) {
					bestIndex = i;
					min = remaining.get(bestIndex) - item;
				}
			}

			if (min == 1) {
				remaining.add(1 - item);
				List<Double> newItem = new ArrayList<>();
				newItem.add(item);
				result.add(newItem);
			} else {
				result.get(bestIndex).add(item);
				remaining.remove(bestIndex);
				remaining.add(bestIndex, item - min);
			}

		}
		return result;
	}


}
