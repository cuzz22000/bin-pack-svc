package org.cjwilson.binpacking.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.cjwilson.binpacking.api.FirstFit;
import org.junit.Test;

public class FirstFitTest {

	@Test
	public void firstFitRegression() {
		final List<ItemForTest> items = ItemForTest.toTest();

		final List<List<ItemForTest>> bins = new FirstFit<ItemForTest>().pack(1d,items);
		System.out.println("First Fit -> " + bins);
		// expected eg [[0.2, 0.5, 0.1], [0.4, 0.3], [0.7], [0.8]]
		final List<List<ItemForTest>> expected = new ArrayList<>();
		expected.add(Arrays.asList(new ItemForTest(.2), new ItemForTest(.5), new ItemForTest(.1)));
		expected.add(Arrays.asList(new ItemForTest(.4),new ItemForTest(.3)));
		expected.add(Arrays.asList(new ItemForTest(.7)));
		expected.add(Arrays.asList(new ItemForTest(.8)));

		assertThat(bins, equalTo(expected));
	}

}
