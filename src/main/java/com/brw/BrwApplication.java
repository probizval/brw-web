package com.brw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class BrwApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BrwApplication.class, args);
	}
	
	@Bean("threadPoolTaskExecutor")
	public TaskExecutor getAyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(5000);
		executor.setThreadNamePrefix("*** StoreLatLongToBRWDB-");
		executor.initialize();
		return executor;
	}
}
