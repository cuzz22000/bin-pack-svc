package org.cjwilson.structures.binpacking;

import java.util.ArrayList;
import java.util.List;

class FirstFit implements BinPacking {
	@Override
	public List<List<Double>> pack(List<Double> items) {
		List<List<Double>> results = new ArrayList<>();
		results.add(new ArrayList<>());
		for (int i = 0; i < items.size(); i++) {
			boolean added = false;
			for (List<Double> bin : results) {
				if (PackingUtils.sum(bin) + items.get(i) <= 1) {
					bin.add(items.get(i));
					added = true;
					break;
				}
			}
			if (!added) {
				List<Double> newBin = new ArrayList<>();
				newBin.add(items.get(i));
				results.add(newBin);
			}

		}
		return results;
	}

}