package org.cjwilson.binpacking.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultWrapper {
	
	private final Double maxCapacity;
	private final String timeUnit;
	private final Long time;
	private final List<List<ItemEntity>> result;
	
	public ResultWrapper(Double maxCapacity, String timeUnit, Long time, List<List<ItemEntity>> result) {
		this.maxCapacity = maxCapacity;
		this.timeUnit = timeUnit;
		this.time = time;
		this.result = result;
	}
	
	@JsonProperty("max-capacity")
	public Double maxCapacity() {
		return this.maxCapacity;
	}
	
	@JsonProperty("time-unit")
	public String timeUnit() {
		return this.timeUnit;
	}
	
	@JsonProperty("total-time")
	public final Long time() {
		return this.time;
	}
	
	@JsonProperty("bins")
	public List<List<ItemEntity>> result(){
		return this.result;
	}

}
