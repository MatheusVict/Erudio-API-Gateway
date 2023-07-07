package br.com.erudio.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
    return builder.routes()
            .route(predicateSpec -> predicateSpec
                    .path("/get")
                    .filters(gatewayFilterSpec -> gatewayFilterSpec
                            .addRequestHeader("Hello", "world")
                            .addRequestParameter("hello", "world")
                    )
                    .uri("http://httpbin.org:80")
            )
            .route(predicateSpec -> predicateSpec.
                    path("/cambio-service/**")
                    .uri("lb://cambio-service"))
            .route(predicateSpec -> predicateSpec.
                    path("/book-service/**")
                    // uri says where it should search for
                    .uri("lb://book-service"))
            .build();
  }
}
