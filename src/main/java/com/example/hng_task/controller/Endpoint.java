package com.example.hng_task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
@RequestMapping("/api/")
public class Endpoint {


//    @RequestMapping(method = RequestMethod.GET, path = "/api")
    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getInfo(@RequestParam String slack_name, @RequestParam String track) {
        try {
            DayOfWeek currentDayOfWeek = LocalDateTime.now(ZoneId.of("UTC")).getDayOfWeek();
//            String currentDay = currentDayOfWeek.getDisplayName(
//                    DayOfWeek.,
//                    java.util.Locale.ENGLISH
//            );
            String currentDay = currentDayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String utcTime = LocalDateTime.now(ZoneId.of("UTC")).format(formatter);

            String githubRepoUrl = "https://github.com/Martins-O/hngx-intern-first-task";
            String githubFileUrl = githubRepoUrl + "/blob/main/Endpoint.java";

            ApiResponse response = new ApiResponse(
                    slack_name,
                    currentDay,
                    utcTime,
                    track,
                    githubFileUrl,
                    githubRepoUrl,
                    200
            );

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}