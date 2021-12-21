package com.br.mycapital.config;

import com.br.mycapital.resources.CartaResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CartaConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerClasses(CartaResource.class);
    }
}
