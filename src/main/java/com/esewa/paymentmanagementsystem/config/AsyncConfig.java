package com.esewa.paymentmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {
        @Bean(name = "threadPoolTaskExecutor1")
        public Executor executor1() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(4);
            executor.setMaxPoolSize(4);
            executor.setQueueCapacity(50);
            executor.setThreadNamePrefix("CustomExecutor1::");
            executor.initialize();
            return executor;
        }

        @Bean(name = "threadPoolTaskExecutor2")
        public Executor executor2() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(4);
            executor.setMaxPoolSize(4);
            executor.setQueueCapacity(50);
            executor.setThreadNamePrefix("CustomExecutor2::");
            executor.initialize();
            return executor;
        }
    }
