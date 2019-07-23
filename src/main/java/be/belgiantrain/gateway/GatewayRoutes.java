package be.belgiantrain.gateway;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@SuppressWarnings({"DanglingJavadoc", "unused"})
public class GatewayRoutes {

    /**
     * <pre>
     *     return builder.routes()
     *                 .route(r -> r.path("/service/**").uri("lb://mySimpleService"))
     *                 .build();
     * </pre>
     */
    /*@Bean
    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "Convert2Lambda"})
    public RouteLocator routeLocator(final RouteLocatorBuilder builder) {
        Function<PredicateSpec, Route.AsyncBuilder> all = new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(final PredicateSpec predicateSpec) {
                index = index == elasticUris.length ? 0 : index++;
                String elasticUri = elasticUris[index];
                return predicateSpec
                        .path("/elastic/**") // query-service
                        .filters(f -> f.stripPrefix(1))
                        .uri(elasticUri); // http://sl01757v.ops.vdab.be:9200, lb://query-service
                // "http://sl01757v.ops.vdab.be:9200"
            }
        };
        return builder.routes().route(all).build();
    }*/

}