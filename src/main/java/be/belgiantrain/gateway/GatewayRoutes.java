package be.belgiantrain.gateway;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@SuppressWarnings({"unused"})
public class GatewayRoutes {

    @Bean
    public RouteLocator routeLocator(final RouteLocatorBuilder builder) {
        return builder.routes().build();
    }

}