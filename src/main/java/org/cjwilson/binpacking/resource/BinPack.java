package org.cjwilson.binpacking.resource;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cjwilson.binpacking.api.BestFit;
import org.cjwilson.binpacking.api.FirstFit;
import org.cjwilson.binpacking.api.NextFit;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Path("/")
@Api(value = "Various algorithms for bin packing eg: Next Fit, First Fit, Best Fit")
@Produces(MediaType.APPLICATION_JSON)
public class BinPack {

	@POST
	@Path("nextfit")
	@Timed
	@ExceptionMetered
	@ApiOperation(value = "Next Fit binpack algorithm", authorizations = { @Authorization("apiKey") })
	public Response nextFit(final BinPackRequest binPackRequest) {
		final List<List<ItemEntity>> result = new NextFit<ItemEntity>().pack(binPackRequest.maxCapacity(),
				binPackRequest.items());
		return Response.ok(result).build();
	}
	
	@POST
	@Path("firstfit")
	@Timed
	@ExceptionMetered
	@ApiOperation(value = "First Fit binpack algorithm", authorizations = { @Authorization("apiKey") })
	public Response firstFit(final BinPackRequest binPackRequest) {
		final List<List<ItemEntity>> result = new FirstFit<ItemEntity>().pack(binPackRequest.maxCapacity(),
				binPackRequest.items());
		return Response.ok(result).build();
	}
	
	@POST
	@Path("bestfit")
	@Timed
	@ExceptionMetered
	@ApiOperation(value = "Best Fit binpack algorithm", authorizations = { @Authorization("apiKey") })
	public Response bestFit(final BinPackRequest binPackRequest) {
		final List<List<ItemEntity>> result = new BestFit<ItemEntity>().pack(binPackRequest.maxCapacity(),
				binPackRequest.items());
		return Response.ok(result).build();
	}

}
