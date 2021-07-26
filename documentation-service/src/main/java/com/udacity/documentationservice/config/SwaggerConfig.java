package com.udacity.documentationservice.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.udacity.documentationservice.model.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Primary
@Configuration
public class SwaggerConfig {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String SWAGGER_URL = "/v2/api-docs";
    private static final String SWAGGER_VERSION = "2.0";

    List<SwaggerService> swaggerServices;

    @PostConstruct
    public void init() {
        List<String> serviceNames = discoveryClient.getServices();

        this.swaggerServices = serviceNames.stream()
                .map(name -> {
                    List<ServiceInstance> serviceInstance = discoveryClient.getInstances(name);
                    if (serviceInstance.isEmpty()) return null;
                    String url = serviceInstance.get(0).getUri().toString();
                    return new SwaggerService(name, url + SWAGGER_URL, SWAGGER_VERSION);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<SwaggerService> getServices() {
        return swaggerServices;
    }
}
