package org.cjwilson.structures.binpacking;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public class ItemForTest implements Item {

	private Double weight;

	public ItemForTest(Double weight) {
		this.weight = weight;
	}

	@Override
	public Double weight() {
		return this.weight;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.weight());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != ItemForTest.class) {
			return false;
		}
		final ItemForTest itemForTestObj = (ItemForTest) obj;
		return Objects.equals(itemForTestObj.weight(), weight());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ItemForTest.class).add("weight", weight()).toString();
	}

	static List<ItemForTest> toTest() {
		return Arrays.asList(new ItemForTest[] { new ItemForTest(0.2), new ItemForTest(0.5), new ItemForTest(0.4),
				new ItemForTest(0.7), new ItemForTest(0.1), new ItemForTest(0.3), new ItemForTest(0.8) });
	}

}
