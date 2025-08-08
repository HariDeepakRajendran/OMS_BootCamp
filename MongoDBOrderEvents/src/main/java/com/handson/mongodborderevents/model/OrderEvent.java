package com.handson.mongodborderevents.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OrderEvent {
    private String type;
    private Map<String, Object> payload;

    public OrderEvent() {
    }

    public OrderEvent(String type, Map<String, Object> payload) {
        this.type = type;
        this.payload = payload;
    }
    public String getType() {
        return type;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}

