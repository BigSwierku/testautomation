package com.jsystems.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Device implements Serializable {
    public String type;

    @JsonProperty(value = "device.model", required = true)
    public List<DeviceModel> deviceModel;
    @Override
    public String toString() {
        return "Device{" +
                "type='" + type + '\'' +
                ", models=" + deviceModel +
                '}';
    }
}
