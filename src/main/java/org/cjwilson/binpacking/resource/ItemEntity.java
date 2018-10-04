package org.cjwilson.binpacking.resource;

import java.util.Objects;

import org.cjwilson.binpacking.api.Item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.MoreObjects;

public class ItemEntity implements Item {

	private String itemId;
	private Double weight;

	@JsonCreator
	public ItemEntity(@JsonProperty(ITEM_ID) String itemId, @JsonProperty(WEIGHT) double weight) {
		this.itemId = itemId;
		this.weight = weight;
	}

	@JsonProperty(ITEM_ID)
	public String id() {
		return this.itemId;
	}

	@Override
	@JsonProperty(WEIGHT)
	public Double weight() {
		return this.weight;
	}

	@Override
	public int hashCode() {

		return Objects.hash(id(), weight());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != ItemEntity.class) {
			return false;
		}
		final ItemEntity itemEntityObj = (ItemEntity) obj;
		return Objects.equals(itemEntityObj.id(), this.id()) && Objects.equals(itemEntityObj.id(), this.id());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ItemEntity.class).add(ITEM_ID, this.id()).add(WEIGHT, this.weight())
				.toString();
	}

	private static final String ITEM_ID = "id";
	private static final String WEIGHT = "weight";
}
