package org.cjwilson.binpacking.resource;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

public class BinPackRequest {

	private Double maxCapacity;
	private List<ItemEntity> items;

	@JsonCreator
	public BinPackRequest(@JsonProperty(MAX_CAPACITY) Double maxCapacity, @JsonProperty(ITEMS) List<ItemEntity> items) {
		this.maxCapacity = maxCapacity;
		this.items = items;
	}

	@JsonProperty(MAX_CAPACITY)
	public Double maxCapacity() {
		return this.maxCapacity;
	}

	@JsonProperty(ITEMS)
	public List<ItemEntity> items() {
		return ImmutableList.copyOf(this.items);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.maxCapacity(), this.items());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != BinPackRequest.class) {
			return false;
		}
		final BinPackRequest binPackRequestObj = (BinPackRequest) obj;
		return Objects.equals(binPackRequestObj.maxCapacity(), this.maxCapacity())
				&& Objects.equals(binPackRequestObj.items(), this.items());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(BinPackRequest.class).add(MAX_CAPACITY, this.maxCapacity())
				.add(ITEMS, this.items()).toString();
	}

	private static final String MAX_CAPACITY = "max-capacity";
	private static final String ITEMS = "items";

}
