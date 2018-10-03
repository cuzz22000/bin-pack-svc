package org.cjwilson.structures.binpacking;

import java.util.List;

public class PackingUtils {
	
	public static int numOfBins(List<Double> items) {
		Double num = Math.ceil(sum(items)) / 1;
		return num.intValue();
	}

	public static Double sum(List<Double> items) {
		double sum = 0;
		for (double item : items) {
			sum += item;
		}
		return sum;
	}

}
