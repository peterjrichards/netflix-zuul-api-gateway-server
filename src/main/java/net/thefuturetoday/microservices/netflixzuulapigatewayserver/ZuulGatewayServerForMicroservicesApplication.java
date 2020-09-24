package net.thefuturetoday.microservices.netflixzuulapigatewayserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulGatewayServerForMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayServerForMicroservicesApplication.class, args);
	}

	@Bean
	//creating a sampler called always sampler
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}
}
