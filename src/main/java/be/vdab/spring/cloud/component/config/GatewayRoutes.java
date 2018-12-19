package be.vdab.spring.cloud.component.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayRoutes {

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public RouteLocator routeLocator(final RouteLocatorBuilder builder) {

        // http://localhost:8284/state-machine

        Function<PredicateSpec, Route.AsyncBuilder> all = new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(final PredicateSpec predicateSpec) {
                return predicateSpec.path("/**").filters(f -> f.stripPrefix(1)).uri("lb://state-machine");
            }
        };

        return builder.routes().route(all).build();

        /*return builder.routes()
                .route(r ->
                        r.path("/**")
                                .filters(
                                        f -> f.stripPrefix(1)
                                )
                                .uri("http://httpbin.org:80")
                )
                .build();*/
    }

}