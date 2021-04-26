package com.bivgroup.module.dadataclient.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty(value = "value")
    public String value;
    @JsonProperty(value = "unrestricted_value")
    public String unrestrictedValue;
    @JsonProperty(value = "data")
    public Data data;
}
