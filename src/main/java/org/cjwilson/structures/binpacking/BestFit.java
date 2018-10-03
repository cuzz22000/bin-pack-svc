package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BestFit<T extends Item> implements BinPacking<T>{

	@Override
	public List<List<T>> pack(List<T> items) {
		List<List<T>> result = new ArrayList<>();
		List<Double> remaining = new LinkedList<>();
		for (T item : items) {
			double min = 1;
			int bestIndex = 0;
			for (int i = 0; i < remaining.size(); i++) {
				if (item.weight() <= remaining.get(i) && remaining.get(i) - item.weight() < min) {
					bestIndex = i;
					min = remaining.get(bestIndex) - item.weight();
				}
			}

			if (min == 1) {
				remaining.add(1 - item.weight());
				List<T> newItem = new ArrayList<>();
				newItem.add(item);
				result.add(newItem);
			} else {
				result.get(bestIndex).add(item);
				remaining.remove(bestIndex);
				remaining.add(bestIndex, item.weight() - min);
			}
		}
		return result;
	}

}
