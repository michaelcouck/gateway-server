package be.vdab.spring.cloud.component.config;

/*import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import java.util.function.Function;*/

import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("DanglingJavadoc")
public class GatewayRoutes {

    /**
     * <pre>
     *     return builder.routes()
     *                 .route(r -> r.path("/service/**").uri("lb://mySimpleService"))
     *                 .build();
     * </pre>
     */
    /*@Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public RouteLocator routeLocator(final RouteLocatorBuilder builder) {
        Function<PredicateSpec, Route.AsyncBuilder> all = new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(final PredicateSpec predicateSpec) {
                return predicateSpec
                        .path("/query-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://query-service");
            }
        };
        return builder.routes().route(all).build();
    }*/

}