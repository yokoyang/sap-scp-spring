package com.example.demo.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestViewModel {
    private String email;

    @JsonProperty("LiuYang")
    private String liuyang;

    public String getLiuyang() {
        return liuyang;
    }

    public void setLiuyang(String liuyang) {
        this.liuyang = liuyang;
    }

    public String getEmail() {
        return email;
    }

    public TestViewModel(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TestViewModel() {
    }
}
