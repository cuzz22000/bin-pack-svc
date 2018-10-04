package org.cjwilson.binpacking.resource;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class BinPackRequestTest {

	@Test
	  public void toJson() throws JsonProcessingException {
	    final BinPackRequest binPackRequest = new BinPackRequest(123d,toTest());
	    String actual = MAPPER.writeValueAsString(binPackRequest);
	    System.out.println(actual);
	    String expected = fixture("fixtures/bin-pack-entity.json");
	    assertThat(actual, equalTo(expected));
	  }

	@Test
	public void fromJson() throws IOException {
		final String json = fixture("fixtures/bin-pack-entity.json");
		final BinPackRequest actual = MAPPER.readValue(json, BinPackRequest.class);
		final BinPackRequest expected = new BinPackRequest(123d,toTest());
		assertThat(actual, equalTo(expected));
	}

	public static List<ItemEntity> toTest() {
		return Arrays.asList(new ItemEntity[] { new ItemEntity("abc123", 0.2), new ItemEntity("abc123", 0.5),
				new ItemEntity("abc123", 0.4),new ItemEntity("abc123", 0.7),new  ItemEntity("abc123", 0.1),
				new ItemEntity("abc123", 0.3), new ItemEntity("abc123", 0.8) });
	}

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
}
