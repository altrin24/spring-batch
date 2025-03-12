package com.example.springbatch.cli;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job importCsvJob;

    public JobRunner(JobLauncher jobLauncher, Job importCsvJob) {
        this.jobLauncher = jobLauncher;
        this.importCsvJob = importCsvJob;
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(importCsvJob, params);
    }
}

