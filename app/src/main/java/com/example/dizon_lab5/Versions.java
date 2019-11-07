package com.example.dizon_lab5;


public class Versions {
    int logo;
    String name, version, api, releaseDate;

    public Versions(int logo, String name, String version, String api, String releaseDate) {
        this.logo = logo;
        this.name = name;
        this.version = version;
        this.api = api;
        this.releaseDate = releaseDate;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApi() {
        return api;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}
