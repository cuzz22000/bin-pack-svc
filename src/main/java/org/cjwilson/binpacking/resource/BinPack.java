package org.cjwilson.binpacking.resource;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cjwilson.binpacking.api.BestFit;
import org.cjwilson.binpacking.api.BinPacking;
import org.cjwilson.binpacking.api.FirstFit;
import org.cjwilson.binpacking.api.NextFit;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Stopwatch;

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
		final ResultWrapper resultWrapper = this.executeBinPacking(new NextFit<>(),binPackRequest.items(), binPackRequest.maxCapacity());
		return Response.ok(resultWrapper).build();
	}

	@POST
	@Path("firstfit")
	@Timed
	@ExceptionMetered
	@ApiOperation(value = "First Fit binpack algorithm", authorizations = { @Authorization("apiKey") })
	public Response firstFit(final BinPackRequest binPackRequest) {
		final ResultWrapper resultWrapper = this.executeBinPacking(new FirstFit<>(),binPackRequest.items(), binPackRequest.maxCapacity());
		return Response.ok(resultWrapper).build();
	}

	@POST
	@Path("bestfit")
	@Timed
	@ExceptionMetered
	@ApiOperation(value = "Best Fit binpack algorithm", authorizations = { @Authorization("apiKey") })
	public Response bestFit(final BinPackRequest binPackRequest) {
		final ResultWrapper resultWrapper = this.executeBinPacking(new BestFit<>(),binPackRequest.items(), binPackRequest.maxCapacity());
		return Response.ok(resultWrapper).build();
	}

	private ResultWrapper executeBinPacking(BinPacking<ItemEntity> binPacking, List<ItemEntity> items,
			Double maxCapacity) {
		final Stopwatch stopwatch = Stopwatch.createStarted();
		final List<List<ItemEntity>> result = binPacking.pack(maxCapacity, items);
		stopwatch.stop();
		final ResultWrapper resultWrapper = new ResultWrapper(maxCapacity, TIME_UNIT.toString(),
				stopwatch.elapsed(TIME_UNIT), result);
		return resultWrapper;
	}

	private static final TimeUnit TIME_UNIT = TimeUnit.MICROSECONDS;

}
