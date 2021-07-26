package com.udacity.documentationservice.model;

public class SwaggerService {

    private String name;
    private String url;
    private String version;

    public SwaggerService(String name, String url, String version) {
        this.name = name;
        this.version = version;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }
}
