package com.fibi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/fibiService")
public class RestfulController {

	@Autowired
	FibUtility fibUtility;

	@SuppressWarnings("static-access")
	@Path("/print/fib/{number}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response executeFibnacci(@PathParam("number") int number)
			throws Exception {

		if (number < 0 || number > 20) {
			return Response.status(Status.BAD_REQUEST).entity(
					"{ Number is not Positive OR exceeded Max Limit }").build();
		}

		// FibUtility util = new FibUtility();
		List<Integer> results = new ArrayList<Integer>();
		results.add(0);

		// printing Fibonacci series upto number
		for (int i = 1; i <= number; i++) {
			results.add(fibUtility.fibonacci(i));
		}
		return Response.status(200).entity(results).build();
	}

}
