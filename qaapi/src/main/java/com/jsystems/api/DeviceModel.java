package com.jsystems.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DeviceModel implements Serializable {
    public String produce;

    @JsonProperty(value = "screen.size", required = true)
    @NotNull
    @Size()
    public String screenSize;

    @Override
    public String toString() {
        return "DeviceModel{" +
                "produce='" + produce + '\'' +
                ", screenSize='" + screenSize + '\'' +
                '}';
    }
}
