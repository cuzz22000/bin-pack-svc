package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.List;

class FirstFit<T extends Item> implements BinPacking<T> {
	
	@Override
	public List<List<T>> pack(List<T> items) {
		List<List<T>> results = new ArrayList<>();
		results.add(new ArrayList<>());
		for (int i = 0; i < items.size(); i++) {
			boolean added = false;
			for (List<T> bin : results) {
				if (PackingUtils.sum(bin) + items.get(i).weight() <= 1) {
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