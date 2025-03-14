package com.example.springbatch.config;


import com.example.springbatch.entity.ExcelData;
import com.example.springbatch.file.csv.CsvItemReader;
import com.example.springbatch.file.csv.CsvItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.batch.core.repository.JobRepository;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;



@Configuration
public class BatchJobConfig {

    private final JobRepository jobRepository;
    private final DataSource dataSource;

    public BatchJobConfig(JobRepository jobRepository, DataSource dataSource) {
        this.jobRepository = jobRepository;
        this.dataSource = dataSource;

    }
    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors()); // Utilizes all CPU cores
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;

    }

    @Bean
    public ItemProcessor<ExcelData, ExcelData> processor() {
        return item -> {
            System.out.println("Processing: " + Runtime.getRuntime().availableProcessors());
            return item;
        };
    }

    @Bean
    public ItemWriter<ExcelData> writer() {
        return new CsvItemWriter(dataSource);
    }

    @Bean
    public FlatFileItemReader csvItemReader(){

        return new CsvItemReader("/Users/jerry/Downloads/customers-2000000.csv");
    }



    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<ExcelData, ExcelData>chunk(10000, transactionManager)
                .reader(csvItemReader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }





    @Bean
    public Job importCsvJob() {
        return new JobBuilder("importCsvJob", jobRepository)
                .start(step1(jobRepository, new ResourcelessTransactionManager()))
                .build();
    }
}
