package com.example.demo;

import brave.Tracing;
import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import zipkin2.reporter.xray_udp.XRayUDPReporter;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public WebClient webClient(WebClient.Builder builder){
		return builder.build();
	}

	@Bean
	public Tracing tracing(@Value("${spring.application.name:spring-tracing}")String serviceName){
		return Tracing.newBuilder()
				.localServiceName(serviceName)
				.spanReporter(XRayUDPReporter.create())
				.traceId128Bit(true) // X-Ray requires 128-bit trace IDs
				.sampler(Sampler.ALWAYS_SAMPLE) // Configure as desired
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
