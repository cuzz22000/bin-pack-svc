package org.cjwilson.binpacking.api;

import java.util.ArrayList;
import java.util.List;

public class NextFit<T extends Item> implements BinPacking<T> {

	@Override
	public List<List<T>> pack(Double capacity, List<T> items) {
		List<List<T>> result = new ArrayList<>();
		double curr = 0;
		List<T> bin = new ArrayList<>();
		result.add(bin);
		for (T item : items) {
			if (item.weight() + curr <= capacity) {
				bin.add(item);
			} else {
				curr = 0;
				bin = new ArrayList<>();
				result.add(bin);
				bin.add(item);
			}
			curr += item.weight();
		}
		return result;
	}
}
