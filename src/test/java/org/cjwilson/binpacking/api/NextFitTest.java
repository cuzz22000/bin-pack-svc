package org.cjwilson.binpacking.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.cjwilson.binpacking.api.NextFit;
import org.junit.Test;

public class NextFitTest {

	@Test
	public void nextFitRegression() {
		final List<ItemForTest> items = ItemForTest.toTest();

		final List<List<ItemForTest>> bins = new NextFit<ItemForTest>().pack(1d,items);
		System.out.println("Next Fit -> " + bins);
		// expected eg [[0.2, 0.5], [0.4], [0.7, 0.1], [0.3], [0.8]]]
		final List<List<ItemForTest>> expected = new ArrayList<>();
		expected.add(Arrays.asList(new ItemForTest(.2), new ItemForTest(.5)));
		expected.add(Arrays.asList(new ItemForTest(.4)));
		expected.add(Arrays.asList(new ItemForTest(.7),new ItemForTest(.1)));
		expected.add(Arrays.asList(new ItemForTest(.3)));
		expected.add(Arrays.asList(new ItemForTest(.8)));

		assertThat(bins, equalTo(expected));
	}
	
}
