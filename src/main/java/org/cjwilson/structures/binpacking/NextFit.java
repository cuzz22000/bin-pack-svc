package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.List;

public class NextFit<T extends Item> implements BinPacking<T> {

	@Override
	public List<List<T>> pack(List<T> items) {
		List<List<T>> result = new ArrayList<>();
		double curr = 0;
		List<T> bin = new ArrayList<>();
		result.add(bin);
		for (T item : items) {
			if (item.weight() + curr <= 1) {
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
