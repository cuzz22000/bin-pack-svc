package org.cjwilson.structures.binpacking;

import java.util.List;

public interface BinPacking<T extends Item> {

	public List<List<T>> pack(Double capacity, List<T> items);
}