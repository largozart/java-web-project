package com.bivgroup.module.dadataclient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResult {

    @JsonProperty(value = "location")
    public Location location;
}
