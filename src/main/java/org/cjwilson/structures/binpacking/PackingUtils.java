package org.cjwilson.structures.binpacking;

import java.util.List;

public class PackingUtils {
	
	public static <T extends Item> int numOfBins(List<T> items) {
		Double num = Math.ceil(sum(items)) / 1;
		return num.intValue();
	}

	public static <T extends Item> Double sum(List<T> items) {
		double sum = 0;
		for ( Item item : items) {
			sum += item.weight();
		}
		return sum;
	}

}
