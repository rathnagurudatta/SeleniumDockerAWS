package com.orangehrm.pojos;

public class Environment {
    private String url;
    private Integer max_number_of_attempts;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMax_number_of_attempts() {
        return max_number_of_attempts;
    }

    public void setMax_number_of_attempts(Integer max_number_of_attempts) {
        this.max_number_of_attempts = max_number_of_attempts;
    }
}
