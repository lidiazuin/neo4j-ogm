/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */

package org.neo4j.ogm.drivers.http.response;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.neo4j.ogm.model.GraphModel;
import org.neo4j.ogm.response.Response;
import org.neo4j.ogm.result.ResultGraphModel;

/**
 * @author vince
 * @author Luanne Misquitta
 */
public class GraphModelResponse extends AbstractHttpResponse<ResultGraphModel> implements Response<GraphModel> {

	public GraphModelResponse(CloseableHttpResponse httpResponse) throws IOException {
		super(httpResponse.getEntity().getContent(), ResultGraphModel.class);
	}

	@Override
	public GraphModel next() {
		ResultGraphModel graphModel = nextDataRecord("graph");

		if (graphModel != null) {
			return graphModel.model();
		}
		return null;
	}

	@Override
	public void close() {
		//Nothing to do, the response has been closed already
	}
}