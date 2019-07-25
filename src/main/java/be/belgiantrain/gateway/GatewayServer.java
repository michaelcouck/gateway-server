package be.belgiantrain.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * <pre>
 *     3) Spring cloud gateway voor load balancing
 * </pre>
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootConfiguration
@EnableAutoConfiguration
@Import(GatewayRoutes.class)
@ComponentScan({"be.belgiantrain.gateway"})
public class GatewayServer {

    public static void main(final String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }

}