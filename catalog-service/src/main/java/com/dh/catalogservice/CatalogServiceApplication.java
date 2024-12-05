package com.dh.catalogservice;

import com.dh.catalogservice.configuration.CustomRandomLoadBalancer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//es una anotación que te permite especificar varios balanceadores de carga en una única clase de configuración.
@LoadBalancerClients({
		@LoadBalancerClient(name = "movie-service", configuration = CustomRandomLoadBalancer.class),
		@LoadBalancerClient(name = "serie-service", configuration = CustomRandomLoadBalancer.class)
})
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
