package dev.keyairen.ufcdashboard;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UfcDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfcDashboardApplication.class, args);
    }

    @Bean
    CommandLineRunner run(JobLauncher jobLauncher, Job job) {
        return args -> {
            jobLauncher.run(job, new org.springframework.batch.core.JobParameters());
        };
    }
}
