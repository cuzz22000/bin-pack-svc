package org.cjwilson.binpacking.api;

import java.util.ArrayList;
import java.util.List;

public class FirstFit<T extends Item> implements BinPacking<T> {
	
	@Override
	public List<List<T>> pack(Double capacity, List<T> items) {
		List<List<T>> results = new ArrayList<>();
		results.add(new ArrayList<>());
		for (int i = 0; i < items.size(); i++) {
			boolean added = false;
			for (List<T> bin : results) {
				if (PackingUtils.sum(bin) + items.get(i).weight() <= capacity) {
					bin.add(items.get(i));
					added = true;
					break;
				}
			}
			if (!added) {
				List<T> newBin = new ArrayList<>();
				newBin.add(items.get(i));
				results.add(newBin);
			}

		}
		return results;
	}

}