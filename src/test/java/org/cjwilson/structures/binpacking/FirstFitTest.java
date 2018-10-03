package org.cjwilson.structures.binpacking;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FirstFitTest {

	@Test
	public void firstFitRegression() {
		final List<Double> items = Arrays.asList(new Double[] { 0.2, 0.5, 0.4, 0.7, 0.1, 0.3, 0.8 });

		final List<List<Double>> bins = new FirstFit().pack(items);
		System.out.println("First Fit -> " + bins);
		// expected eg [[0.2, 0.5, 0.1], [0.4, 0.3], [0.7], [0.8]]
		final List<List<Double>> expected = new ArrayList<>();
		expected.add(Arrays.asList(.2, .5, .1));
		expected.add(Arrays.asList(.4, .3));
		expected.add(Arrays.asList(.7));
		expected.add(Arrays.asList(.8));

		assertThat(bins, equalTo(expected));
	}

}
