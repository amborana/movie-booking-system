package org.aashish.perfect; // ✅ Your chosen package name

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PerfectMovieBookingApp {
    public static void main(String[] args){
        SpringApplication.run(PerfectMovieBookingApp.class, args);
    }
}
