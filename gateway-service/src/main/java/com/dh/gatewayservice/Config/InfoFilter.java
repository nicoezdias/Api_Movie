package com.dh.gatewayservice.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class InfoFilter extends AbstractGatewayFilterFactory<InfoFilter.Config> {

    public static Logger LOG = LoggerFactory.getLogger(InfoFilter.class);

    public InfoFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            LOG.info("Endpoint de la request " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOG.info("Puerto de la Instancia: " + exchange.getResponse().getHeaders().get("port"));
            }));
        }));
    }

    public static class Config {

    }
}
