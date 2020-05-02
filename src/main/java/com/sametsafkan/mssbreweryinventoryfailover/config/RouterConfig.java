package com.sametsafkan.mssbreweryinventoryfailover.config;

import com.sametsafkan.mssbreweryinventoryfailover.web.InventoryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction inventoryRoute(InventoryHandler handler){
        return RouterFunctions.route(GET("/inventory-failover")
                .and(accept(MediaType.APPLICATION_JSON)),
                handler::listInventory);
    }
}
