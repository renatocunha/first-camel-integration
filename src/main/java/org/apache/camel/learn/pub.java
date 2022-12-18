package org.apache.camel.learn;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.minio.MinioConstants;
import static org.apache.commons.lang3.RandomStringUtils.*;

public class pub extends EndpointRouteBuilder {
	@Override
    public void configure() throws Exception {
        from(timer("fire").repeatCount("10"))
                .routeId("minio-producer")
                .process(exchange -> {
                    exchange.getIn().setHeader(MinioConstants.OBJECT_NAME, pub.randomId() + ".json");
                    exchange.getIn().setHeader(MinioConstants.CONTENT_TYPE, "application/json");
                    exchange.getIn().setBody(pub.generateRandomBody());
                })
                .to(minio("{{bucketName}}").autoCreateBucket(true));
    }

	public static String randomId(){
		String randomId = randomAlphabetic(10).toLowerCase();
		return randomId;
	}

	public static String generateRandomBody() {
		String __id = pub.randomId();
		String message = randomAlphabetic(1000).toUpperCase();
		String body = "{'__id':'" + __id + "', 'message':'" + message + "'}";
		return body;
	}
}
