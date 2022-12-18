package org.apache.camel.learn;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

public class sub extends EndpointRouteBuilder {
	@Override
    public void configure() throws Exception {
        from(minio("{{bucketName}}").delay(1000L).deleteAfterRead(false)).routeId("minio-consumer").log("Mensagem Recebida: ${body}");
    }
}
