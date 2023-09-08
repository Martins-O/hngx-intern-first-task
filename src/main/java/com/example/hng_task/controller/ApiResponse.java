package com.example.hng_task.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {
    @JsonProperty
    private String slack_name;
    @JsonProperty
    private String current_day;
    @JsonProperty
    private String utc_time;
    @JsonProperty
    private String track;
    @JsonProperty
    private String github_file_url;
    @JsonProperty
    private String github_repo_url;
    @JsonProperty
    private int status_code;

    public ApiResponse(String slack_name, String current_day, String utc_time, String track, String github_file_url, String github_repo_url, int status_code) {
        this.slack_name = slack_name;
        this.current_day = current_day;
        this.utc_time = utc_time;
        this.track = track;
        this.github_file_url = github_file_url;
        this.github_repo_url = github_repo_url;
        this.status_code = status_code;
    }

    public String getSlack_name() {
        return slack_name;
    }

    public String getCurrent_day() {
        return current_day;
    }

    public String getUtc_time() {
        return utc_time;
    }

    public String getTrack() {
        return track;
    }

    public String getGithub_file_url() {
        return github_file_url;
    }

    public String getGithub_repo_url() {
        return github_repo_url;
    }

    public int getStatus_code() {
        return status_code;
    }
}
