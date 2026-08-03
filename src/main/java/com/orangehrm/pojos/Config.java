package com.orangehrm.pojos;

import java.util.HashMap;
import java.util.Map;

public class Config {
    Map<String, Environment> environments = new HashMap<>();

    public Map<String, Environment> getenvironments() {
        return environments;
    }

    public void setenvironments(Map<String, Environment> map) {
        this.environments = environments;
    }
}
